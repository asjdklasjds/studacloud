package com.study.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulServer8006 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulServer8006.class,args);
    }
}
