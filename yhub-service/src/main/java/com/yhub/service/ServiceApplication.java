package com.yhub.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author chengtianping
 * @description 服务提供者
 * @date 2018/7/19
 */
@MapperScan("com.yhub.dao")
@ImportResource(locations = {"classpath:mybatis/mybatis-config.xml"})
@SpringBootApplication
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}
