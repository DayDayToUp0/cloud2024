package com.cxt.cloud.controller;

import com.cxt.cloud.entities.Order;
import com.cxt.cloud.resp.ResultData;
import com.cxt.cloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderController
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/3/2 - 15:45
 * @Version 1.0
 */
@RestController
public class OrderController {

   @Resource
   private OrderService orderService;

   /**
    * 创建订单
    */
   @GetMapping("/order/create")
   public ResultData create(Order order)
   {
      orderService.create(order);
      return ResultData.success(order);
   }
}
