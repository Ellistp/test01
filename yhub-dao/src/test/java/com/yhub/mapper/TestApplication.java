package com.yhub.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ImportResource(locations = {"classpath*:spring/*.xml"})
@ComponentScan(basePackages= "com.yhub.mapper")
@MapperScan("com.yhub.dao")
@SpringBootApplication
public class TestApplication {
}
