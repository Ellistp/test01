package com.ctp.yhub;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ImportResource(locations = {"classpath*:spring/*.xml"})
@ComponentScan(basePackages="com.ctp.yhub.dao")
@MapperScan("com.ctp.yhub.dao")
@SpringBootApplication
public class TestApplication {
}
