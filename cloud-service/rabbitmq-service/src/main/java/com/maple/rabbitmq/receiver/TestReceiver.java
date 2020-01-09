package com.maple.rabbitmq.receiver;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author ZhangFZ
 * @date 2020-1-8 17:02
 */
@Component
public class TestReceiver {

    @RabbitListener(queues = "test2")
    public void processC(Integer i, Message message, Channel channel) throws IOException {
        try {
            System.out.println("结果开始" + i);
            Integer a = 10;
            a = a/i;
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
            System.out.println("结果结束" + i);
        } catch (IOException e) {
            e.printStackTrace();
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
        }
    }
}
