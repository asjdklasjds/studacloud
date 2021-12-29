package study.server.impl;

import com.study.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.dao.PaymentDao;
import study.server.PaymentServer;

@Service
public class PaymentServerImpl implements PaymentServer {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
