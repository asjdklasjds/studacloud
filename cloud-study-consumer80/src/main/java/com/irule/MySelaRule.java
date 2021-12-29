package com.irule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelaRule {

    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }

}
