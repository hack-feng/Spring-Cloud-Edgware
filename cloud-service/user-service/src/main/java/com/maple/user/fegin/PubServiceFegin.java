package com.maple.user.fegin;

import com.maple.user.fegin.fallback.PubServiceError;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ZhangFZ
 * @date 2020-1-14 17:38
 */
@FeignClient(name = "pub-service", fallback = PubServiceError.class)
public interface PubServiceFegin {

    /**
     * fegin调用pub-service
     * @param speak 招呼小二
     * @return 小二返回的话语
     */
    @GetMapping("/pubServiceUser/serviceUser")
    String serviceUser(@RequestParam("speak") String speak);

    /**
     * fegin调用pub-service，酒馆比较繁忙，休眠15s后应答
     * @param speak 招呼小二
     * @return 小二返回的话语
     */
    @GetMapping("/testHystrix/busyPub")
    String busyPub(@RequestParam("speak") String speak);
}
