package com.cxt.cloud.controller;

import com.cxt.cloud.entities.PayDao;
import com.cxt.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: ConsumerController
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/2/28 - 16:49
 * @Version 1.0
 */
@RestController
public class OrderController {

    //    private final String PaymentSrv_URL = "http://localhost:8001";//先写死，硬编码
    private final String PaymentSrv_URL = "http://cloud-payment-service";//先写死，硬编码

    @Resource
    RestTemplate restTemplate;

    @PostMapping("/consumer/add")
    public ResultData<Integer> add(@RequestBody PayDao payDao) {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDao, ResultData.class);
    }

    @GetMapping("/consumer/get/{id}")
    public ResultData<PayDao> getPayment(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
    }

    @PutMapping("/consumer/update")
    public ResultData<Integer> update(@RequestBody PayDao payDao) {
        restTemplate.put(PaymentSrv_URL + "/pay/update", payDao, ResultData.class);
        return null;
    }

    @DeleteMapping("/consumer/del/{id}")
    public ResultData<Integer> delete(@PathVariable("id") Integer id) {
        restTemplate.delete(PaymentSrv_URL + "/pay/del/" + id, ResultData.class);
        return null;
    }

    @GetMapping("/info")
    public String getPaymentInfo() {
        return restTemplate.getForObject(PaymentSrv_URL + "/info", String.class);
    }


    @Resource
    DiscoveryClient client;
    @GetMapping("/discovery")
    public String getDiscovery() {
         client.getServices().stream()
                 .forEach(System.out::println);

         client.getInstances("cloud-payment-service").stream()
                 .forEach(System.out::println);

         return  "success";
     }
}
