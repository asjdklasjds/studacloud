package study.controller;

import com.study.pojo.CommentReuslt;
import com.study.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.server.PaymentServer;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentServer paymentServer;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public CommentReuslt getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentServer.getPaymentById(id);
        if (paymentById != null){
            log.info("查询成功=====>" + paymentById);
            return new CommentReuslt(200,"查询成功，端口为：" + serverPort,paymentById);
        }else {
            return new CommentReuslt(400,"没有找到id为" + id + "的信息",null);
        }
    }
}
