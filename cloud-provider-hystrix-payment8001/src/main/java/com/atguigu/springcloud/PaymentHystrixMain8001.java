package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description TODO
 * @Date 2021/2/3 16:25
 * @Created by qyy
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
        System.out.println("Hystrix 服务降级,熔断,限流 服务提供者启动成功");
    }
}
