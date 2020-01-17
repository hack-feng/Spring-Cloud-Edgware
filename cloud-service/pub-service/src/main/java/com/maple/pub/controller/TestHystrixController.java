package com.maple.pub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhangFZ
 * @date 2020-1-17 10:18
 */
@RestController
@RequestMapping("/testHystrix")
public class TestHystrixController {

    @GetMapping("/busyPub")
    public String busyPub(String speak){
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        System.out.println(sdf.format(new Date()) + "【小二收到招呼】：" + speak);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "不好意思客官，让您久等了...";
    }
}
