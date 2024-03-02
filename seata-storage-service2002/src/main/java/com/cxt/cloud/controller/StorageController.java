package com.cxt.cloud.controller;

import com.cxt.cloud.resp.ResultData;
import com.cxt.cloud.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: StorageController
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/3/2 - 15:25
 * @Version 1.0
 */
@RestController
public class StorageController {
    @Resource
    StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public ResultData decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功!");
    }
}
