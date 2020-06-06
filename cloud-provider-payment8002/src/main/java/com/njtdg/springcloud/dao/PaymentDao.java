package com.njtdg.springcloud.dao;


import com.njtdg.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int create(Payment payment);


    public Payment getPaymentId(@Param("id") Long id);
}
