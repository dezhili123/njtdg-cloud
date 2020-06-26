package com.njtdg.springcloud.alibaba.controller;

import jdk.internal.org.objectweb.asm.tree.analysis.BasicValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {


    @GetMapping(value = "/testA")
    public String testA(){
        return "----testA";
    }

    @GetMapping(value = "/testB")
    public String testB(){
        return "-----testB";
    }
}
