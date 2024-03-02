package com.cxt.cloud;

import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ClassName: ${NAME}
 * Description:   ${Description}
 *
 * @Author cxt ( 陈小韬 )
 * @Create ${DATE} - ${TIME}
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.cxt.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient //服务注册和发现
@EnableFeignClients
public class Main2002 {
    public static void main(String[] args) {
        SpringApplication.run(Main2002.class, args);
    }
}