package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：QYY
 * @date ：Created in 2021/2/1 15:46
 * @description：
 * @version:
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //使用LoadBalanced注解赋予restRempate负载均衡能力
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
