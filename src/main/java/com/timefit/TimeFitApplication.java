package com.timefit;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
        exclude = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class}
        //TODO 模拟数据用不到数据库，回头完善了要加上
)
public class TimeFitApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimeFitApplication.class, args);
    }
}
