package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ：QYY
 * @date ：Created in 2021/1/19 16:29
 * @description：
 * @version:
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("--------插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);

        }
    }
        @GetMapping(value = "/payment/get/{id}")
        public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       Payment payment =  paymentService.getPaymentById(id);
        log.info("--------查询结果" + payment);
        if (payment != null){
            return  new CommonResult(200,"查询数据库成功",payment);
        }else {
            return  new CommonResult(444,"对应ID没有记录" + id,null);
        }

    }
}