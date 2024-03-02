package com.cxt.cloud.mygateway;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: MyCustomerGatewayFilter
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/3/1 - 15:35
 * @Version 1.0
 */
@Component
public class MyCustomerGatewayFilterFactory extends AbstractGatewayFilterFactory<MyCustomerGatewayFilterFactory.Config> {
    public MyCustomerGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("status");
    }

    @Override
    public GatewayFilter apply(MyCustomerGatewayFilterFactory.Config config) {
        return (ex, chain)->{
            System.out.println("进入自定义过滤器,配置的status是:" + config.getStatus());
            if (ex.getRequest().getQueryParams().containsKey(config.getStatus())) {
                return chain.filter(ex);
            }else{
                ex.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                DataBufferFactory factory = ex.getResponse().bufferFactory();
                DataBuffer wrap = factory.wrap("错误请求嘻嘻~~~".getBytes(StandardCharsets.UTF_8));
               return ex.getResponse().writeWith(Mono.just(wrap));
            }
        };
    }

    @NoArgsConstructor
    public static class Config {
        @Getter
        @Setter
        private String status;
    }
}
