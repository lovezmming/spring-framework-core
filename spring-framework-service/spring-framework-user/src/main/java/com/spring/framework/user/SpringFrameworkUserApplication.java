package com.spring.framework.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients({"com.spring.framework.explore.api.service","com.spring.framework.user.api.service"})
@EnableHystrix
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan(basePackages = {"com.spring.framework.user.database.mapper"})
@SpringBootApplication
//@Import({DynamicDataSourceRegister.class})
public class SpringFrameworkUserApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringFrameworkUserApplication.class, args);
    }

}
