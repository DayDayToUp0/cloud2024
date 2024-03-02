package com.cxt.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.cxt.cloud.entities.Pay;
import com.cxt.cloud.entities.PayDao;
import com.cxt.cloud.resp.ResultData;
import com.cxt.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: PayController
 * Description:
 *
 * @Author cxt ( 陈小韬 )
 * @Create 2024/2/28 - 15:25
 * @Version 1.0
 */

@RestController
@Log4j2
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {
    @Resource
    PayService payService;

    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    @PostMapping("/pay/add")
    public ResultData<Integer> add(@RequestBody PayDao payDao) {
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDao, pay);
        return ResultData.success(payService.add(pay));
    }

    @DeleteMapping("/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> delete(@PathVariable("id") Integer id) {
        return ResultData.success(payService.delete(id));
    }

    @PutMapping("/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<Integer> update(@RequestBody PayDao payDao) {
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDao, pay);
        return ResultData.success(payService.update(pay));
    }

    @GetMapping("/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> get(@PathVariable("id") Integer id) {
        if(id == -4) throw new RuntimeException("报错了");
        return ResultData.success(payService.getById(id));
    }

    @GetMapping("/pay/list")
    public ResultData<List<Pay>> list() {
        return ResultData.success(payService.getAll());
    }

    @Value("${spring.profiles.active}")
    private String active;

    @Value("${server.port}")
    private String port;

    @GetMapping("/info")
    public  String info(@Value("${cxt.info}") String info) {
        return active+"-info: " + info + "--->port: " +port;
    }
}
