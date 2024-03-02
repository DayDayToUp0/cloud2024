package com.cxt.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.cxt.cloud.apis.PayFeignApi;
import com.cxt.cloud.entities.PayDao;
import com.cxt.cloud.resp.ResultData;
import com.cxt.cloud.resp.ReturnCodeEnum;
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
    PayFeignApi feignApi;

    @PostMapping("/consumer/add")
    public ResultData<Integer> add(@RequestBody PayDao payDao) {
        return feignApi.add(payDao);
    }

    @GetMapping("/fetch/consumer/get/{id}")
    public ResultData<PayDao> getPayment(@PathVariable("id") Integer id) {
        ResultData<PayDao> resultData= null;
        try {
            System.out.println("start: "+DateUtil.now());
            resultData = feignApi.getPayment(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("end: "+DateUtil.now());
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
        return  resultData;
    }

    @PutMapping("/consumer/update")
    public ResultData<Integer> update(@RequestBody PayDao payDao) {
        return feignApi.update(payDao);
    }

    @DeleteMapping("/consumer/del/{id}")
    public ResultData<Integer> delete(@PathVariable("id") Integer id) {
        return feignApi.delete(id);
    }

    @GetMapping("/info")
    public String getPaymentInfo() {
        return feignApi.getPaymentInfo();
    }

}
