package com.spring.framework.user.dataaccess.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class DatabaseConfig
{
    @Value("${database.names}")
    public String names;

    @Value("${database.user.url}")
    public String url;

    @Value("${database.user.class}")
    public String classDriver;

    @Value("${database.user.username}")
    public String username;

    @Value("${database.user.password}")
    public String password;

    public String toString()
    {
        return url + " " + classDriver + " " + username + "" + password;
    }
}
