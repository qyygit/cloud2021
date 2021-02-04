package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：QYY
 * @date ：Created in 2021/2/1 14:16
 * @description：
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain80 {


    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class,args);
        System.out.println("80 订单微服务入住 ookeeper--消费者启动成功");
    }
}
