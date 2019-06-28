package com.spring.framework.user.controller;

import com.spring.framework.user.dataaccess.source.DatabaseConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/config")
public class DatabaseConfigController extends DatabaseConfig
{

    Logger logger = LoggerFactory.getLogger(DatabaseConfigController.class);

    @GetMapping("/getDataBaseConfig")
    public String getDataBaseConfig()
    {
        logger.info(this.toString());
        return toString();
    }

}
