package com.cxt.cloud.config;

import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * ClassName: MyFeignConfig
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/2/29 - 11:18
 * @Version 1.0
 */
@Configuration
public class MyFeignConfig {
    @Bean
    public Retryer feignRetryer() {
//        return Retryer.NEVER_RETRY;
        return new Retryer.Default(1000, 1000, 3);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
