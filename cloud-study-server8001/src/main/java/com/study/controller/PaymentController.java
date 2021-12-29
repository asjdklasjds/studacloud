package com.study.controller;

import com.study.pojo.CommentReuslt;
import com.study.pojo.Payment;
import com.study.server.PaymentServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentServer paymentServer;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("/payment/get/{id}")
    public CommentReuslt getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentServer.getPaymentById(id);
        if (paymentById != null){
            log.info("查询成功=====>" + paymentById);
            return new CommentReuslt(200,"查询成功,端口为：" + serverPort,paymentById);
        }else {
            return new CommentReuslt(400,"没有找到id为" + id + "的信息",null);
        }
    }

    // 获取服务的信息
    @GetMapping(value = "/payment/discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("服务名称：" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVER");
        for (ServiceInstance instance : instances) {
            log.info(instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getInstanceId() + "\t" + instance.getScheme());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/feignTimeout")
    public String paymentFeignTimeOut(){
        try{
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
