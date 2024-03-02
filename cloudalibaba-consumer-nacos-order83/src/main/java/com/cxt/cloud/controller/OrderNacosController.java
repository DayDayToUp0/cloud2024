package com.cxt.cloud.controller;

import com.cxt.cloud.apis.PayFeignSentinelApi;
import com.cxt.cloud.resp.ResultData;
import com.cxt.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: OrderNacosController
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/3/1 - 19:57
 * @Version 1.0
 */
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/pay/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
//      String result = restTemplate.getForObject(serverURL + "/pay/nacos/" + id, String.class);
        String result = restTemplate.getForObject(serverURL + "/pay/nacos/" + id, String.class);
        return result + "\t" + "    我是OrderNacosController83调用者。。。。。。";
    }

    @Resource
    private PayFeignSentinelApi payFeignSentinelApi;

    @GetMapping(value = "/consumer/pay/nacos/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo) {
        ResultData payByOrderNo = payFeignSentinelApi.getPayByOrderNo(orderNo);
        System.out.println("payByOrderNo = " + payByOrderNo);
        return payByOrderNo;
    }

}
