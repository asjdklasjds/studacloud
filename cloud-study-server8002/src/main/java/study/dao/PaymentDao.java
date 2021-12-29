package study.dao;

import com.study.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public Payment getPaymentById(@Param("id") Long id);
}
