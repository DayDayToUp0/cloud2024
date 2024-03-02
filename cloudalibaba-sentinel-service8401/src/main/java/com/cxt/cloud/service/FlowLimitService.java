package com.cxt.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * ClassName: FlowLimitService
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/3/1 - 22:54
 * @Version 1.0
 */
@Service
public class FlowLimitService
{
    @SentinelResource(value = "common")
    public void common()
    {
        System.out.println("------FlowLimitService come in");
    }
}
