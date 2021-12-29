package com.study.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int curr;
        int next;
        for (;;){
            curr = atomicInteger.get();
            next = curr >= 2147483647 ? 0 : curr + 1;
            if (atomicInteger.compareAndSet(curr,next))
                return next;
        }
    }


    @Override
    public ServiceInstance instance(List<ServiceInstance> services) {

        int index = getAndIncrement() % services.size();

        return services.get(index);
    }
}
