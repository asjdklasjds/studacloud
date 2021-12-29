package com.study.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "PAYMENT-SERVER-HYSTRIX",fallback = FallBackService.class)
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id);


    @GetMapping("/payment/hystrix/time_out/{id}")
    public String time_out(@PathVariable("id") Integer id);
}
