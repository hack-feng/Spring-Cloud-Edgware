package com.maple.user.controller;

import com.maple.user.fegin.PubServiceFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public String goPub(){
        System.out.println("有一天，失恋的张三想喝酒，于是他来到酒馆。");
        String speak = "小二，来两坛上等的二锅头，两斤牛肉，一只烤羊腿";
        System.out.println("【发送消息】：" + speak);
        String result = pubServiceFegin.serviceUser(speak);
        System.out.println("【收到小二回话】：" + result);
        System.out.println("张三进入了漫长的等待期...");
        return result;
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

    /**
     * 张三去了一个火爆的酒馆，演示Hystrix熔断器
     */
    @GetMapping("/goBusyPub")
    public String goBusyPub(){
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        System.out.println("张三来到了一个非常火爆的酒馆，人多的地方，就肯定好喝");
        String speak = "小二，来两坛上等的二锅头，两斤牛肉，一只烤羊腿";
        System.out.println(sdf.format(new Date()) + "【发送消息】：" + speak);
        String result = pubServiceFegin.busyPub(speak);
        System.out.println(sdf.format(new Date()) + "【收到小二回话】：" + result);
        System.out.println("张三进入了漫长的等待期...");
        return result;
    }

}
