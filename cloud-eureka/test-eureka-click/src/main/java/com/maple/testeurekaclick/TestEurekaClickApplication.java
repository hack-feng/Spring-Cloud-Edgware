package com.maple.testeurekaclick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TestEurekaClickApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestEurekaClickApplication.class, args);
    }

}
