package com.spring.framework.explore.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class DatabaseConfig
{

    @Value("${database.explore.url}")
    public String url;

    @Value("${database.explore.class}")
    public String classDriver;

    @Value("${database.explore.username}")
    public String username;

    @Value("${database.explore.password}")
    public String password;

    public String toString()
    {
        return url + " " + classDriver + " " + username + "" + password;
    }

}
