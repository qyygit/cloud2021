package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：QYY
 * @date ：Created in 2021/1/28 14:27
 * @description：
 * @version:
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class,args);
        System.out.println("----------Eureka Server 7002 服务注册中心启动成功");
    }
}
