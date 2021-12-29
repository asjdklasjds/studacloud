package com.stuay.server;

import com.study.pojo.CommentReuslt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "PAYMENT-SERVER")
public interface FeignServer {

    @GetMapping("/payment/get/{id}")
    public CommentReuslt getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feignTimeout")
    public String paymentFeignTimeOut();
}
