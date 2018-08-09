package com.yhub.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/8
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
@MapperScan("com.yhub.mapper")
@EnableTransactionManagement
public class MybatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.yhub.mapper");
        return mapperScannerConfigurer;
    }
}
