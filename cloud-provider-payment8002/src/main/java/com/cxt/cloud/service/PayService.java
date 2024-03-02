package com.cxt.cloud.service;

import com.cxt.cloud.entities.Pay;

import java.util.List;

/**
 * ClassName: PayService
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/2/28 - 15:22
 * @Version 1.0
 */
public interface PayService {
    int add(Pay pay);

    int delete(Integer id);

    int update(Pay pay);

    Pay getById(Integer id);

    List<Pay> getAll();
}
