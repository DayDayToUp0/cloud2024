package com.cxt.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ClassName: PayDao
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/2/28 - 15:21
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayDao implements Serializable {
    private Integer id;
    //支付流水号
    private String payNo;
    //订单流水号
    private String orderNo;
    //用户账号ID
    private Integer userId;
    //交易金额
    private BigDecimal amount;
}
