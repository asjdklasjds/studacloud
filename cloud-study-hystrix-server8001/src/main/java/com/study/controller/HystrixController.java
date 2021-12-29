package com.study.controller;

import com.study.server.HystrixServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class HystrixController {

    @Resource
    private HystrixServer hystrixServer;

    @Value("server.port")
    private String servicePort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        String ok = hystrixServer.ok(id);
        log.info("******serverPort " + servicePort);
        return ok;
    }

    @GetMapping("/payment/hystrix/time_out/{id}")
    public String time_out(@PathVariable("id") Integer id){
        log.info("ID=======================" + id);
        String s = hystrixServer.time_out(id);
        log.info("******serverPort " + servicePort);
        return s;
    }

    //====== 服务熔断
    @GetMapping("/payment/circui/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return hystrixServer.paymentCircuitBreaker(id);
    }

}
