package com.maple.pub.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author ZhangFZ
 * @date 2020-1-14 17:37
 */
@FeignClient(name = "user-service")
public interface UserServiceFegin {

    /**
     * 小二通知用户上菜
     */
    @PostMapping("/notifyUser")
    String notifyUser(String notifySpeak);

}
