package com.mq.springmq.rabbitmq;

import com.mq.springmq.model.MyMessageFirst;
import com.mq.springmq.model.MyMessageSecond;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by wqg on 2023/1/3.
 */
@Component
@RabbitListener(queues = {"q_B"})
@Slf4j
public class RabbitMessageListenerB {

    private static final String QUEUE_B = "q_B";

    @RabbitHandler
    public void onFirstMessageFromBQueue(MyMessageFirst myMessage) {
        log.info("queue {} received first exchange message: {}", QUEUE_B, myMessage);
    }

    @RabbitHandler
    public void onSecondMessageFromBQueue(MyMessageSecond myMessage) {
        log.info("queue {} received second exchange message: {}", QUEUE_B, myMessage);
    }
}
