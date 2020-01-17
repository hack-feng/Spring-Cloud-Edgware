package com.maple.user.fegin.fallback;

import com.maple.user.fegin.PubServiceFegin;
import org.springframework.stereotype.Component;

/**
 * @author ZhangFZ
 * @date 2020-1-16 13:13
 */
@Component
public class PubServiceError implements PubServiceFegin {
    @Override
    public String serviceUser(String speak) {
        return "啊哦，小二不在店里，程序进入到断路器...";
    }

    @Override
    public String busyPub(String speak) {
        return "啊哦，小二太忙了，程序进入到断路器...";
    }
}
