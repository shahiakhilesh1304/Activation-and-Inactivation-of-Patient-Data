package com.mphrx.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
public class ApiPropertiesConfig {
    @Configuration
    @PropertySource("classpath:config.properties")
    static class Production{

    }

    public static Environment env;

    @Autowired
    public void setEnv(Environment env)
    {
        ApiPropertiesConfig.env = env;
    }
}
