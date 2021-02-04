package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：QYY
 * @date ：Created in 2021/2/1 10:54
 * @description：
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args) {

        SpringApplication.run(PaymentMain8004.class,args);
        System.out.println("----8004-zookeeper微服务提供者启动成功");
    }
}
