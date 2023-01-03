package com.mq.springmq.rabbitmq;

import com.mq.springmq.model.MyMessage;
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
@Slf4j
@RabbitListener(queues = {"q_A"})
public class RabbitMessageListenerA {

    private static final String QUEUE_A = "q_A";

    @RabbitHandler
    public void onFirstMessageFromAQueue(MyMessageFirst myMessage) {
        log.info("queue {} received first exchange message: {}", QUEUE_A, myMessage);
    }

    @RabbitHandler
    public void onSecondMessageFromAQueue(MyMessageSecond myMessage) {
        log.info("queue {} received second exchange message: {}", QUEUE_A, myMessage);
    }

    @RabbitHandler
    public void onDefaultMessageFromAQueue(MyMessage myMessage) {
        log.info("queue {} received default exchange message: {}", QUEUE_A, myMessage);
    }

}
