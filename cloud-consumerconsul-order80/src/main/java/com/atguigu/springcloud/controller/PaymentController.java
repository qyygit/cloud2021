package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ：QYY
 * @date ：Created in 2021/2/1 15:48
 * @description：
 * @version:
 */
@RestController
@Slf4j
public class PaymentController {

    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value="/consumer/payment/consul")
    public  String  paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }

}
