package com.njtdg.springcloud.controller;

import com.njtdg.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInof_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInof_OK(id);
        log.info("result"+result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInof_TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInof_TimeOut(id);
        log.info("result"+result);
        return result;
    }

}
