package com.maple.user.config;

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
     * 注释：@LoadBalanced配置启用Ribbon负载均衡
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory factory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //单位为ms
        factory.setReadTimeout(15000);
        //单位为ms
        factory.setConnectTimeout(15000);
        return factory;
    }
}
