package com.cxt.cloud.service.impl;

import com.cxt.cloud.entities.Pay;
import com.cxt.cloud.mapper.PayMapper;
import com.cxt.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: PayServiceImpl
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/2/28 - 15:22
 * @Version 1.0
 */
@Service
public class PayServiceImpl implements PayService {
    @Resource
    private PayMapper mapper;
    @Override
    public int add(Pay pay) {
        return mapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return mapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return mapper.selectAll();
    }
}
