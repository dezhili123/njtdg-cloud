package com.njtdg.springcloud.controller;




import com.njtdg.springcloud.entities.CommonResult;
import com.njtdg.springcloud.entities.Payment;
import com.njtdg.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功,serverPort:"+serverPort,result);
        }
        return new CommonResult(444,"插入数据库失败",null);
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentId(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentId(id);
        log.info("****插入结果："+payment+"哈哈11");
        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }
        return new CommonResult(444,"没有对应记录，查询ID:"+id,null);
    }


 }
