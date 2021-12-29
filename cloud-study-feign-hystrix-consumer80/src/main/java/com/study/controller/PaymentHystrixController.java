package com.study.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.study.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentTimeOutFallbackMethods")
public class PaymentHystrixController {


    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return paymentHystrixService.ok(id);
    }


    @GetMapping("/consumer/payment/hystrix/time_out/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000")  //3秒钟以内就是正常的业务逻辑
////    })
    @HystrixCommand
    public String time_out(@PathVariable("id") Integer id){
        log.info("=============================" + new Date());
        if (id == 2){
            throw new RuntimeException("客户端运行错误");
        }
        return paymentHystrixService.time_out(id);
    }

//    //兜底方法
//    public String paymentTimeOutFallbackMethod(){
//        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
//    }
//
//    兜底方法
    public String paymentTimeOutFallbackMethods(){
        log.info("==========================" + new Date());
        return "(┬＿┬)";
    }
}
