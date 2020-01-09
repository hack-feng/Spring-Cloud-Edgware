package com.maple.rabbitmq.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangFZ
 * @date 2020-1-8 17:02
 */
@RestController
public class TestSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test")
    public String test(){
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<>();
            String a = "MQ测试消息" + i;
            map.put(a, i);
            rabbitTemplate.convertAndSend("testDirectExchange", "TestDirectRouting", map);
        }
        return "发送成功";
    }

    @GetMapping("/test2")
    public String test2(){
        rabbitTemplate.convertAndSend("testDirectExchange", "TestDirectRouting2", 0);
        return "发送成功2";
    }

}
