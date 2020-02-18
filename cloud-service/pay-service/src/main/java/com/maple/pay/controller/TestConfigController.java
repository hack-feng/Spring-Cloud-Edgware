package com.maple.pay.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangFZ
 * @date 2020/2/7 10:50
 **/
@Scope
@RestController
public class TestConfigController {

    /**
     * 从配置文件中取出该值
     */
    @Value("${name}")
    private String name;

    @GetMapping("/test")
    private String test(){
        return "配置文件中获取到的内容为：" + name;
    }

}
