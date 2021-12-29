package com.study.server.impl;

import com.study.dao.PaymentDao;
import com.study.pojo.Payment;
import com.study.server.PaymentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServerImpl implements PaymentServer {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
