package com.mq.springmq.rabbitmq;

import com.mq.springmq.model.MyMessageSecond;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by wqg on 2023/1/3.
 */
@Component
@RabbitListener(queues = {"q_C"})
@Slf4j
public class RabbitMessageListenerC {

    private static final String QUEUE_C = "q_C";

    @RabbitHandler
    public void onSecondMessageFromCQueue(MyMessageSecond myMessage) {
        log.info("queue {} received second exchange message: {}", QUEUE_C, myMessage);
    }

}
