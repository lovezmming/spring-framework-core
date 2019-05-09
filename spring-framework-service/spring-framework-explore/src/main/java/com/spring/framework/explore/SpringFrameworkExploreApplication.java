package com.spring.framework.explore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients
@EnableHystrix
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication
public class SpringFrameworkExploreApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringFrameworkExploreApplication.class, args);
    }

}
