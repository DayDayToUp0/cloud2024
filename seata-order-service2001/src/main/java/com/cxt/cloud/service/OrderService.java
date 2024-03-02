package com.cxt.cloud.service;

import com.cxt.cloud.entities.Order;

/**
 * ClassName: OrderService
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/3/2 - 14:54
 * @Version 1.0
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);

}
