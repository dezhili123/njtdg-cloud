package com.njtdg.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInof_OK(Integer id) {
        return "----- PaymentFallbackService Fallback ---paymentInof_OK";
    }

    @Override
    public String paymentInof_TimeOut(Integer id) {
        return "----- PaymentFallbackService Fallback ---paymentInof_TimeOut";
    }
}
