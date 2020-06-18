package com.njtdg.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInof_OK(Integer id){
        return "线程池: "+Thread.currentThread().getName()+" paymentInof_OK ,id: "+id;
    }


    @HystrixCommand(fallbackMethod = "paymentInof_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInof_TimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {

        }
        return "线程池: "+Thread.currentThread().getName()+" paymentInof_TimeOut ,id: "+id+"耗时3秒钟";
    }


    public String paymentInof_TimeOutHandler(Integer id){
        return "线程池: "+Thread.currentThread().getName()+" paymentInof_TimeOutHandler ,id: "+id+"耗时3秒钟";
    }


    //==服务熔断

}
