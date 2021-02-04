package com.atguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
*@ClassName: 
*@Description
*@Author Qyy
*@Date 2021/1/18
*@Time 16:38
*/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8001 {
    public static void main(String[] args) {
    SpringApplication.run(PaymentMain8001.class,args);
        System.out.println("----8001-微服务提供者启动成功");
    }
}
