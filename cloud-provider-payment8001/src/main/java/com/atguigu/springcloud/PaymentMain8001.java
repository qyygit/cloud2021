package com.atguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 
/**
*@ClassName: 
*@Description
*@Author Qyy
*@Date 2021/1/18
*@Time 16:38
*/
@SpringBootApplication
public class PaymentMain8001 {
    public static void main(String[] args) {
    SpringApplication.run(PaymentMain8001.class,args);
        System.out.println("8001-服务提供者启动成功");
    }
}
