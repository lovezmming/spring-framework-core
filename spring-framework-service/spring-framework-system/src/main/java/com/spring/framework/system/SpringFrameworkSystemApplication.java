package com.spring.framework.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients({"com.spring.framework.system.api.service"})
@EnableHystrix
@EnableDiscoveryClient
@MapperScan({"com.spring.framework.system.database.mapper"})
@SpringBootApplication
public class SpringFrameworkSystemApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringFrameworkSystemApplication.class, args);
    }

}
