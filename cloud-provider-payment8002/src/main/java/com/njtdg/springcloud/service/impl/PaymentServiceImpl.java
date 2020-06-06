package com.njtdg.springcloud.service.impl;

import com.njtdg.springcloud.dao.PaymentDao;
import com.njtdg.springcloud.entities.Payment;
import com.njtdg.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentId(Long id) {
        return paymentDao.getPaymentId(id);
    }
}
