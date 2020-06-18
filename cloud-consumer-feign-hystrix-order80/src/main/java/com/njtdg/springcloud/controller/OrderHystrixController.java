package com.njtdg.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.njtdg.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethond")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInof_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInof_OK(id);
        return result;
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInof_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
//    })
    @HystrixCommand
    public String paymentInof_TimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInof_TimeOut(id);
    }

    public String paymentInof_TimeOutHandler(Integer id){
        return "线程池: "+Thread.currentThread().getName()+" paymentInof_TimeOutHandler ,id: "+id+"耗时3秒钟";
    }

    //下面是全局fallback方法
    public String payment_Global_FallbackMethond(){
        return "Global异常处理信息，请稍后再试!";
    }
}
