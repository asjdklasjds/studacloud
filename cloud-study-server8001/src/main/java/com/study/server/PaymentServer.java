package com.study.server;

import com.study.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentServer {
    public Payment getPaymentById(Long id);
}
