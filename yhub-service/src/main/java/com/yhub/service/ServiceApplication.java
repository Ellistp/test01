package com.yhub.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author chengtianping
 * @description 服务提供者
 * @date 2018/7/19
 */
@MapperScan("com.yhub.dao")
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=true)
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}
