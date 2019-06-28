package com.spring.framework.explore.controller;

import com.spring.framework.explore.database.DatabaseConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/explore")
public class ExploreManageController extends DatabaseConfig
{

    @GetMapping("/getDatabaseConfig")
    public String getDatabaseConfig()
    {
        System.out.println(toString());
        return this.toString();
    }
}
