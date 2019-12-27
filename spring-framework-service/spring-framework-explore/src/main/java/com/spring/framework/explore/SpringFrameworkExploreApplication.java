package com.spring.framework.explore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients({"com.spring.framework.explore.api.service"})
@EnableHystrix
@EnableDiscoveryClient
@MapperScan({"com.spring.framework.explore.database.mapper"})
@SpringBootApplication
public class SpringFrameworkExploreApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringFrameworkExploreApplication.class, args);
    }

}
