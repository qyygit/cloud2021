package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Date 2021/2/3 16:37
 * @Created by qyy
 */
@Service
public class PaymentService {


    public  String paymentInfo_ok(Integer id){
        return  "线程池 :  " + Thread.currentThread().getName() + "paymentInfo_ok ,id  " + id +  "\t" +  "O(∩_∩)O哈哈~";
    }

    /**
     * @author: Mrs Yang
     * @description: TODO
     * @date: 2021/2/4 10:29
     * @param id
     * @return java.lang.String
     */
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            //设置这个线程的超时时间是3s，3s内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
//    })
    public String paymentInfo_Timeout(Integer id){
        int timeNumber = 3;
//        int age = 10/0;
        try{
            TimeUnit.MILLISECONDS.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_Timeout,id："+id+"\t"+"O(∩_∩)O哈哈~"+"   耗时(秒)：3";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   8001服务端提供者系统繁忙或者运行报错，请稍后再试,id："+id+"\t"+"o(╥﹏╥)o";
    }

}
