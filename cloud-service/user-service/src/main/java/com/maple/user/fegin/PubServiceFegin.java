package com.maple.user.fegin;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ZhangFZ
 * @date 2020-1-14 17:38
 */
@FeignClient(name = "pub-service")
public interface PubServiceFegin {

    /**
     * fegin调用pub-service
     * @param speak 招呼小二
     * @return 小二返回的话语
     */
    @GetMapping("/pubServiceUser/serviceUser")
    String serviceUser(@RequestParam("speak") String speak);
}
