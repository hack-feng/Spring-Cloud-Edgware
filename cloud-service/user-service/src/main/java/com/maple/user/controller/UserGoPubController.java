package com.maple.user.controller;

import com.maple.user.fegin.PubServiceFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户去酒馆消费Controller
 * @author ZhangFZ
 * @date 2020-1-14 17:24
 */
@RestController
@RequestMapping("/userGoPub")
public class UserGoPubController {

    private final PubServiceFegin pubServiceFegin;

    @Autowired
    public UserGoPubController(PubServiceFegin pubServiceFegin) {
        this.pubServiceFegin = pubServiceFegin;
    }

    /**
     * 去酒馆
     */
    @GetMapping("/goPub")
    public void goPub(){
        System.out.println("有一天，失恋的张三想喝酒，于是他来到酒馆。");
        String speak = "小二，来两坛上等的二锅头，两斤牛肉，一只烤羊腿";
        System.out.println("【发送消息】：" + speak);
        String result = pubServiceFegin.serviceUser(speak);
        System.out.println("【收到小二回话】：" + result);
        System.out.println("张三进入了漫长的等待期...");
    }

    /**
     * 小二通知上菜
     */
    @PostMapping("/notifyUser")
    public String notifyUser(String notifySpeak){
        System.out.println("【收到小二来话】：" + notifySpeak);
        System.out.println("心情不好，你还这么慢，理你个锤子");
        return "";
    }
}
