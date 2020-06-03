package com.njtdg.springcloud.controller;


import com.njtdg.springcloud.entities.CommonResult;
import com.njtdg.springcloud.entities.Payment;
import com.njtdg.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功",result);
        }
        return new CommonResult(444,"插入数据库失败",null);
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentId(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentId(id);
        log.info("****插入结果："+payment+"哈哈11");
        if(payment != null){
            return new CommonResult(200,"查询成功",payment);
        }
        return new CommonResult(444,"没有对应记录，查询ID:"+id,null);
    }
 }
