package com.cxt.cloud.apis;

import com.cxt.cloud.entities.PayDao;
import com.cxt.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: PayFeignApi
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/2/29 - 10:19
 * @Version 1.0
 */
//@FeignClient(value = "cloud-payment-service")
@FeignClient(value = "cloud-gateway")
public interface PayFeignApi {
    @PostMapping("/pay/add")
    ResultData<Integer> add(@RequestBody PayDao payDao);

    @GetMapping("/pay/get/{id}")
    ResultData<PayDao> getPayment(@PathVariable("id") Integer id);

    @PutMapping("/pay/update")
    ResultData<Integer> update(@RequestBody PayDao payDao);

    @DeleteMapping("/pay/del/{id}")
    ResultData<Integer> delete(@PathVariable("id") Integer id);

    @GetMapping("/info")
    String getPaymentInfo();

    @GetMapping(value = "/pay/circuit/{id}")
    String myCircuit(@PathVariable("id") Integer id);

    /**
     * Resilience4j Bulkhead 的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/bulkhead/{id}")
    String myBulkhead(@PathVariable("id") Integer id);

    /**
     * Resilience4j Ratelimit 的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/ratelimit/{id}")
    String myRatelimit(@PathVariable("id") Integer id);


    /**
     * Micrometer(Sleuth)进行链路监控的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/micrometer/{id}")
    String myMicrometer(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例01
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/gateway/get/{id}")
    ResultData getById(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例02
     *
     * @return
     */
    @GetMapping(value = "/pay/gateway/info")
    ResultData<String> getGatewayInfo();
}
