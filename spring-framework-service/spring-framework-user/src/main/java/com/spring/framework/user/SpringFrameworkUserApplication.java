package com.spring.framework.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients({"com.spring.framework.user.api.service", "com.spring.framework.explore.api.service", "com.spring.framework.system.api.service"})
@EnableHystrix
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan({"com.spring.framework.user.database.mapper", "com.spring.framework.user.database.custom"})
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class SpringFrameworkUserApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringFrameworkUserApplication.class, args);
    }

}
