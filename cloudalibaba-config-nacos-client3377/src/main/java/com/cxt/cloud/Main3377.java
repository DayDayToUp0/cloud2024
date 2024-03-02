package com.cxt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * ClassName: ${NAME}
 * Description:   ${Description}
 *
 * @Author cxt ( 陈小韬 )
 * @Create ${DATE} - ${TIME}
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main3377 {
    public static void main(String[] args) {
        SpringApplication.run(Main3377.class, args);
    }
}