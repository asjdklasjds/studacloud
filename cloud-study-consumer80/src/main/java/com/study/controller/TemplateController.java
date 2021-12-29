package com.study.controller;

import com.study.lb.LoadBalancer;
import com.study.pojo.CommentReuslt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class TemplateController {

//    private static final String URL = "http://localhost:8001/";
    private static final String URL = "http://PAYMENT-SERVER";

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/comm/payment/get/{id}")
    public CommentReuslt getPaymentById(@PathVariable("id") Long id){
//        return restTemplate.getForObject(URL+"/payment/get/" + id,CommentReuslt.class);
//        ResponseEntity<CommentReuslt> forEntity = restTemplate.getForEntity(URL + "/payment/get/" + id, CommentReuslt.class);
//        if (forEntity.getStatusCode().is2xxSuccessful()){
//            log.info(forEntity.getHeaders().toString());
//            return forEntity.getBody();
//        }else {
//            return new CommentReuslt(400,"错误",null);
//        }

        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVER");

        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/get/" + id,CommentReuslt.class);
    }



}
