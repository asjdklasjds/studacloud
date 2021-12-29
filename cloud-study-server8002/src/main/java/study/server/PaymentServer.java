package study.server;

import com.study.pojo.Payment;

public interface PaymentServer {
    public Payment getPaymentById(Long id);
}
