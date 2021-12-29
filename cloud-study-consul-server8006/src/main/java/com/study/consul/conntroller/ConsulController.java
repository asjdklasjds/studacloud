package com.study.consul.conntroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@Slf4j
public class ConsulController {

    @Value("server.port")
    private String serverValue;

    @GetMapping("/consul/payment")
    public String getConsulPayment(){
        return "SpringCloud whit consul  port = " + serverValue + "  UUID = " + UUID.randomUUID().toString();
    }
}
