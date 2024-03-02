package com.cxt.cloud.service.impl;

import com.cxt.cloud.apis.AccountFeignApi;
import com.cxt.cloud.apis.StorageFeignApi;
import com.cxt.cloud.entities.Order;
import com.cxt.cloud.mapper.OrderMapper;
import com.cxt.cloud.resp.ResultData;
import com.cxt.cloud.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * ClassName: OrderServiceImpl
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/3/2 - 14:54
 * @Version 1.0
 */
@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
    @Resource
    private AccountFeignApi accountFeignApi;
    @Resource
    private StorageFeignApi storageFeignApi;
    @Resource
    private OrderMapper orderMapper;

    @Override
    @GlobalTransactional(name = "ccccc-x-t", rollbackFor = Exception.class)
    public void create(Order order) {
        String xid = RootContext.getXID();
        log.info("==================>开始新建订单"+"\t"+"xid_order:" +xid);
        order.setStatus(0);
        orderMapper.insertSelective(order);
        log.info("==================>新建订单完成"+"\t"+"xid_order:" +xid);
        System.out.println();
        Order one = orderMapper.selectOne(order);
        if(one!=null){
            log.info("-------> 新建订单成功，one info: "+one);
            System.out.println();
            // 扣减库存
            log.info("-------> 订单微服务开始调用Storage库存，做扣减count");
            storageFeignApi.decrease(one.getProductId(),one.getCount());
            log.info("-------> 订单微服务结束调用Storage库存，做扣减完成");
            System.out.println();
            // 扣减账户
            log.info("-------> 订单微服务开始调用Account账号，做扣减money");
            accountFeignApi.decrease(one.getUserId(),one.getMoney());
            log.info("-------> 订单微服务结束调用Account账号，做扣减完成");
            System.out.println();
        }
        log.info("-------> 修改订单状态");
        one.setStatus(1);
        Example example = new Example(Order.class);
        example.createCriteria().andEqualTo("userId",one.getUserId())
                .andEqualTo("productId",one.getProductId());
        int updateResult = orderMapper.updateByExampleSelective(one, example);
        log.info("-------> 修改订单状态完成"+"\t"+updateResult);
        log.info("-------> one info: "+one);
        System.out.println();
        log.info("==================>结束新建订单"+"\t"+"xid_order:" +xid);
        System.out.println();

    }
}
