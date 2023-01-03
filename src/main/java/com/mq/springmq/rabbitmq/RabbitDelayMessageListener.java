package com.mq.springmq.rabbitmq;

import com.mq.springmq.model.MyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by wqg on 2023/1/3.
 */
@Component
@Slf4j
public class RabbitDelayMessageListener {

    private static final String QUEUE_DELAY_DONE = "queue_delay_done";

    @RabbitListener(queues = {QUEUE_DELAY_DONE})
    public void onDelayMessageFromDelayDoneQueue (MyMessage myMessage) {
        log.info("queue {} received delay message: {}", QUEUE_DELAY_DONE, myMessage);
    }

}
