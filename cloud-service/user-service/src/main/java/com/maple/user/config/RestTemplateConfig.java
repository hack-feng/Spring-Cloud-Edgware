package com.maple.user.config;

import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZhangFZ
 * @date 2020-1-16 10:32
 */
@Configuration
public class RestTemplateConfig {
    /**
     * 开启Fegin重试机制
     */
    @Bean
    Retryer feignRetryer() {
        return  new Retryer.Default(1L, 5L, 3);
    }

    /**
     * 注释：@LoadBalanced配置启用Ribbon负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //单位为ms
        factory.setReadTimeout(15000);
        //单位为ms
        factory.setConnectTimeout(15000);
        return new RestTemplate(factory);
    }
}
