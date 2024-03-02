package com.cxt.cloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * ClassName: AccountService
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/3/2 - 15:31
 * @Version 1.0
 */
public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}
