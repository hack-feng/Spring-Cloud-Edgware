package com.maple.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author ZhangFZ
 * @date 2020-1-8 16:53
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue testDirectQueue(){
        return new Queue("testDirectQueue");
    }

    @Bean
    public Queue test2(){
        return new Queue("test2");
    }

    @Bean
    DirectExchange testDirectExchange(){
        return new DirectExchange("testDirectExchange");
    }

    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with("TestDirectRouting");
    }

    @Bean
    Binding bindingDirect2(){
        return BindingBuilder.bind(test2()).to(testDirectExchange()).with("TestDirectRouting2");
    }

}
