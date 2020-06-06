package com.njtdg.springcloud.service;

import com.njtdg.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {


    public int create(Payment payment);


    public Payment getPaymentId(@Param("id") Long id);
}
