package com.yhub.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * * 组合了 @Configuration @EnableAutoConfiguration @ComponentScan
 * @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 * 关闭特定的自动配置
 * 服务的消费者
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.yhub.service.impl"})
@MapperScan(basePackages = {"com.yhub.dao"})
public class WebApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
