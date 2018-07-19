package com.yhub.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ImportResource(locations = {"classpath*:spring/*.xml"})
@ComponentScan(basePackages="com.yhub.dao")
@MapperScan("com.yhub.dao")
@SpringBootApplication
public class TestApplication {
}
