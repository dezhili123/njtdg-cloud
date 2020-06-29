package com.njtdg.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.njtdg.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
