package com.mq.springmq.rabbitmq;

import com.mq.springmq.model.MyMessage;
import com.mq.springmq.model.MyMessageFirst;
import com.mq.springmq.model.MyMessageSecond;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by wqg on 2023/1/3.
 */
@Component
public class RabbitMessageService {

    private static final String EXCHANGE_FIRST = "first";

    private static final String EXCHANGE_SECOND = "second";

    private static final String EXCHANGE_DELAY_BEGIN = "exchange_delay_begin";

    private static final String QUEUE_NAME_A = "q_A";

    private static final String ROUTING_KEY_C = "is_C";

    private static final String DELAY_ROUTING_KEY = "delay";

    private final RabbitTemplate rabbitTemplate;

    public RabbitMessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     *  指定exchange，无routingKey
     * @param myMessage
     */
    public void sendFirstExchangeMessage(MyMessageFirst myMessage) {
        rabbitTemplate.convertAndSend(EXCHANGE_FIRST,"", myMessage);
    }

    /**
     *  指定exchange和routingKey
     * @param myMessage
     */
    public void sendSecondExchangeMessage(MyMessageSecond myMessage) {
        String routingKey = myMessage.getSecondMessage().equals(ROUTING_KEY_C) ? ROUTING_KEY_C : "";
        rabbitTemplate.convertAndSend(EXCHANGE_SECOND, routingKey, myMessage);
    }

    /**
     *  向默认exchange中发送消息， 此处routingKey对应queue
     * @param myMessage
     */
    public void sendDefaultExchangeMessage(MyMessage myMessage) {
        rabbitTemplate.convertAndSend(QUEUE_NAME_A, myMessage);
    }

    /**
     *  向EXCHANGE_DELAY_BEGIN发送消息
     * @param myMessage
     */
    public void sendDelayMessage(MyMessage myMessage) {
        rabbitTemplate.convertAndSend(EXCHANGE_DELAY_BEGIN, DELAY_ROUTING_KEY, myMessage);
    }

}
