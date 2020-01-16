package com.maple.user.controller;

import com.maple.user.fegin.PubServiceFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟大量用户去酒馆消费
 * @author ZhangFZ
 * @date 2020-1-15 19:39
 */
@RestController
@RequestMapping("/moreUserGoPubController")
public class MoreUserGoPubController {

    private final PubServiceFegin pubServiceFegin;

    private final RestTemplate restTemplate;

    @Autowired
    public MoreUserGoPubController(PubServiceFegin pubServiceFegin, RestTemplate restTemplate) {
        this.pubServiceFegin = pubServiceFegin;
        this.restTemplate = restTemplate;
    }

    /**
     * 模拟Fegin大量用户去酒馆
     */
    @GetMapping("/moreUserGoPub")
    public void moreUserGoPub(){
        for (int i = 0; i < 10; i++) {
            String speak = "小二，来两坛上等的" + i + "锅头，两斤牛肉，一只烤羊腿";
            System.out.println("【发送消息】：" + speak);
            String result = pubServiceFegin.serviceUser(speak);
            System.out.println("【收到小二回话】：" + result);
        }
    }

    /**
     * 模拟RestTemplate大量用户去酒馆
     */
    @GetMapping("/moreUserGoPubRest")
    public void moreUserGoPubRest(){
        for (int i = 0; i < 10; i++) {
            String speak = "通过RestTemplate传音----> 小二，来两坛上等的" + i + "锅头，两斤牛肉，一只烤羊腿";
            System.out.println("【发送消息】：" + speak);
            //调用在Eureka注册的实例，对应调用的spring.application.name，不区分大小写
            String url = "http://PUB-SERVICE/pubServiceUser/serviceUser?speak={speak}";
            Map<String, Object> map = new HashMap<>(16);
            map.put("speak", speak);
            String result = restTemplate.getForEntity(url, String.class, map).getBody();
            System.out.println("【收到小二回话】：" + result);
        }
    }
}
