package com.yhub.web.security;

import java.util.List;

import javax.annotation.Resource;

import com.yhub.entity.user.PermissionDO;
import com.yhub.entity.user.RoleDO;
import com.yhub.entity.user.RolePermissionDO;
import com.yhub.entity.user.UserDO;
import com.yhub.entity.user.UserRoleDO;
import com.yhub.service.PermissionService;
import com.yhub.service.RolePermissionService;
import com.yhub.service.RoleService;
import com.yhub.service.UserRoleService;
import com.yhub.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.CollectionUtils;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/3
 */
public class SpringBootShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private PermissionService permissionService;

    @Resource
    private RolePermissionService rolePermissionService;

    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 此方法调用hasRole,hasPermission的时候才会进行回调
     *  权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*
         * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
         * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
         * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
         * 缓存过期之后会再次执行。
         */
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String account = String.valueOf(principals.getPrimaryPrincipal());

        UserDO userDO = userService.selectByAccount(account);
        if(userDO == null){
            //没找到帐号
            throw new UnknownAccountException();
        }
        List<UserRoleDO> userRoleDOS = userRoleService.selectRolesByUserId(userDO.getId());
        if(CollectionUtils.isEmpty(userRoleDOS)){
            throw new AuthenticationException("当前用户缺少角色!");
        }
        for (UserRoleDO userRoleDO : userRoleDOS) {
            RoleDO roleDO = this.roleService.selectById(userRoleDO.getRoleId());
            // 添加角色
            authorizationInfo.addRole(roleDO.getRoleSign());

            List<RolePermissionDO> rolePermissionDOS = rolePermissionService.selectPermissionsByRoleId(roleDO.getId());
            if(CollectionUtils.isEmpty(rolePermissionDOS)){
                throw new AuthenticationException("当前角色缺少权限!");
            }
            for (RolePermissionDO rolePermissionDO : rolePermissionDOS) {
                PermissionDO permissionDO = this.permissionService.selectById(rolePermissionDO.getPermissionId());
                // 添加权限
                authorizationInfo.addStringPermission(permissionDO.getPermissionSign());
            }
        }
        return authorizationInfo;
    }

    /**
     * 认证信息.(身份验证)
     * Authentication 是用来验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
        // 通过数据库进行验证
        // 通过account从数据库中查找 UserDO对象
        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserDO userDO = this.userService.selectByAccount(account);
        if(userDO == null){
            //没找到帐号
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(account, password, new ShiroByteSource(userDO.getSalt()),getName());
        return authenticationInfo;
    }
}
