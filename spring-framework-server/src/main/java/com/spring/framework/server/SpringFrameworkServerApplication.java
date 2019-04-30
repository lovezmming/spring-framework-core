package com.spring.framework.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringFrameworkServerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringFrameworkServerApplication.class, args);
    }

}
