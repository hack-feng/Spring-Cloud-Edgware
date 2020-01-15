package com.maple.user.controller;

import com.maple.user.fegin.PubServiceFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟大量用户去酒馆消费
 * @author ZhangFZ
 * @date 2020-1-15 19:39
 */
@RestController
@RequestMapping("/moreUserGoPubController")
public class MoreUserGoPubController {

    private final PubServiceFegin pubServiceFegin;

    @Autowired
    public MoreUserGoPubController(PubServiceFegin pubServiceFegin) {
        this.pubServiceFegin = pubServiceFegin;
    }

    @GetMapping("/moreUserGoPub")
    public void moreUserGoPub(){
        for (int i = 0; i < 10; i++) {
            String speak = "小二，来两坛上等的" + i + "锅头，两斤牛肉，一只烤羊腿";
            System.out.println("【发送消息】：" + speak);
            String result = pubServiceFegin.serviceUser(speak);
            System.out.println("【收到小二回话】：" + result);
        }
    }
}
