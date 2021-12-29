package com.stuay.controller;

import com.stuay.server.FeignServer;
import com.study.pojo.CommentReuslt;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class FeignController {

    @Resource
    FeignServer feignServer;


    @GetMapping("/feign/payment/get/{id}")
    public CommentReuslt get(@PathVariable("id") Long id){
        return feignServer.getPaymentById(id);
    }


    @GetMapping("/feign/payment/feignTimeout")
    public String paymentFeignTimeOut(){ return feignServer.paymentFeignTimeOut(); }

}
