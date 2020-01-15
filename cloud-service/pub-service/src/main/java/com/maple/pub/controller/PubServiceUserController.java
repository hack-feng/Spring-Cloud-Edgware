package com.maple.pub.controller;

import com.maple.pub.fegin.UserServiceFegin;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 酒馆服务用户Controller
 * @author ZhangFZ
 * @date 2020-1-14 17:26
 */
@RestController
@RequestMapping("/pubServiceUser")
public class PubServiceUserController {


    private final UserServiceFegin userServiceFegin;

    @Autowired
    public PubServiceUserController(UserServiceFegin userServiceFegin) {
        this.userServiceFegin = userServiceFegin;
    }

    /**
     * 招呼用户
     * @param speak 用户的招呼
     * @return 返回用户的招呼
     */
    @GetMapping("/serviceUser")
    public String serviceUser(String speak){
        System.out.println("【小二收到张三的招呼】：" + speak);
        return "好嘞，客户您稍等...";
    }

    /**
     * 小二上菜
     */
    @GetMapping("/orderUp")
    public void orderUp(){
        String notifySpeak = "客官，您的两坛二锅头，二斤牛肉，一只烤羊腿，您的菜齐了";
        System.out.println("【发送消息】：" + notifySpeak);
        String result = userServiceFegin.notifyUser(notifySpeak);
        if(StringUtils.isBlank(result)){
            System.out.println("小二心想：这人居然不搭理我，一会要黑他一顿");
        }else{
            System.out.println("【小二收到张三的回话】：" + result);
        }
    }
}
