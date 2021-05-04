package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author ：QYY
 * @date ：Created in 2021/1/19 16:29
 * @description：
 * @version:
 */
@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private  String serverPort;

    @Resource
    private PaymentService paymentService;

    @Resource
        private PaymentDao paymentDao;

    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping(value="payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();//获取服务列表信息
        for (String element : services) {
            log.info("******element" + element);  //输出所有服务名称
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");//根据服务名称获取具体的实例
        for (ServiceInstance instance : instances) {
            // 获取服务ID,服务端口号,服务URL
            log.info("" + instance.getServiceId()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }



    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("--------插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功 , ServerPort   " + serverPort,result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);

        }
    }

        @GetMapping(value = "/payment/get/{id}")
        public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       Payment payment =  paymentService.getPaymentById(id);
        log.info("--------查询结果" + payment);
        if (payment != null){
            return  new CommonResult(200,"查询数据库成功 , ServerPort   " + serverPort,payment);
        }else {
            return  new CommonResult(444,"对应ID没有记录" + id,null);
        }

    }


    //自定义ribbon负载均衡算法,返回端口号

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String PaymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return  serverPort;
    }

    @GetMapping(value = "/payment/findAll")
    @RequestMapping
    public List<Payment> findAll(int pageSize , int pagenum){
        RowBounds rowBounds = new RowBounds(pageSize,pagenum);
        List<Payment> all = paymentDao.findAll(rowBounds);

        log.info("--------查询结果" + all);
            return all;
    }
}
