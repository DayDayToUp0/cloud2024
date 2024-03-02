package com.cxt.cloud.mygateway;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * ClassName: MyGlobalGatewayFilter
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/3/1 - 15:16
 * @Version 1.0
 */
@Component
@Log4j2
public class MyGlobalGatewayFilters {
    @Bean
    public GlobalFilter myGlobalGatewayFilter() {
        return new MyGlobalFilter();
    }

    public class MyGlobalFilter implements GlobalFilter, Ordered {
        public static final String START_TIME = "start-time";
        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            exchange.getAttributes().put(START_TIME,System.currentTimeMillis());
            return chain.filter(exchange)
                    .doFinally(signalType ->{
                        Long startTime = exchange.getAttribute(START_TIME);
                        if(startTime != null){
                            log.info("访问接口主机: " + exchange.getRequest().getURI().getHost());
                            log.info("访问接口端口: " + exchange.getRequest().getURI().getPort());
                            log.info("访问接口URL: " + exchange.getRequest().getURI().getPath());
                            log.info("访问接口URL参数: " + exchange.getRequest().getURI().getRawQuery());
                            log.info("访问接口时长: " + (System.currentTimeMillis() - startTime) + "ms");
                            log.info("我是美丽分割线: ###################################################");
                            System.out.println();
                        }
                    });
        }

        @Override
        public int getOrder() {
            return 0;
        }
    }
}
