package com.study.consul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerController {

    public static final String CONSUL_URL = "http://consul-server/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/comm/getConsul")
    public String getConsul(){
        return restTemplate.getForObject(CONSUL_URL + "consul/payment",String.class);
    }
}
