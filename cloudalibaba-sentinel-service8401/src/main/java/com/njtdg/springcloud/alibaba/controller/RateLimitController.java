package com.njtdg.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.njtdg.springcloud.alibaba.myhandler.CustomerBlocakHandler;
import com.njtdg.springcloud.entities.CommonResult;
import com.njtdg.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流ok",new Payment(2020L,"serial001"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping(value = "/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按url限流测试ok",new Payment(2020L,"serial002"));
    }


    @GetMapping(value = "/rateLimit/customerBlocakHandler")
    @SentinelResource(value = "customerBlocakHandler",
            blockHandlerClass = CustomerBlocakHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlocakHandler(){
        return new CommonResult(200,"按客户自定义",new Payment(2020L,"serial003"));
    }
}
