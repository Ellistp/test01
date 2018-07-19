package com.yhub.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * * 组合了 @Configuration @EnableAutoConfiguration @ComponentScan
 * @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 * 关闭特定的自动配置
 * 服务的消费者
 */
@SpringBootApplication
public class WebApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
