package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：QYY
 * @date ：Created in 2021/1/27 15:26
 * @description：  erueka Server 服务注册中心
 * @version:
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
        System.out.println("----------Eureka Server 7001 服务注册中心启动成功");
    }
}
