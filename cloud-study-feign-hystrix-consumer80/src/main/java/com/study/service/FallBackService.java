package com.study.service;

import org.springframework.stereotype.Component;

@Component
public class FallBackService implements PaymentHystrixService {
    @Override
    public String ok(Integer id) {
        return "服务器宕机了，请稍后再试";
    }

    @Override
    public String time_out(Integer id) {
        return "超时";
    }
}
