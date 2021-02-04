package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description TODO
 * @Date 2021/2/4 11:31
 * @Created by qyy
 */
@SpringBootApplication
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
        System.out.println("80订单消费侧 Hystrix 服务降级,熔断,限流 服务消费者启动成功");
    }
}
