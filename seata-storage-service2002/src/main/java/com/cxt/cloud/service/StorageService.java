package com.cxt.cloud.service;

/**
 * ClassName: StorageService
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/3/2 - 15:13
 * @Version 1.0
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
