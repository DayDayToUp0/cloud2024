package com.cxt.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: LoadBalanceConfig
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/3/1 - 19:56
 * @Version 1.0
 */
@Configuration
public class LoadBalanceConfig {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
