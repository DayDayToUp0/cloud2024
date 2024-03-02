package com.cxt.cloud.apis;

import com.cxt.cloud.resp.ResultData;
import com.cxt.cloud.resp.ReturnCodeEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: PayFeignSentinelApi
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/3/2 - 10:41
 * @Version 1.0
 */
//@FeignClient(value = "nacos-payment-provider")
@FeignClient(name = "nacos-payment-provider", fallback = PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi {
    @GetMapping("/pay/nacos/get/{orderNo}")
    ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}

@Component
class PayFeignSentinelApiFallBack implements PayFeignSentinelApi {
    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}

