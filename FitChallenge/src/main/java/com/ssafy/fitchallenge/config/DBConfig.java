package com.ssafy.fitchallenge.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.fitchallenge.model.dao")
public class DBConfig {

}
