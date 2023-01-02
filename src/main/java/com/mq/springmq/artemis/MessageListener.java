package com.mq.springmq.artemis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mq.springmq.model.MyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by wqg on 2022/11/27.
 */
@Component
@Slf4j
public class MessageListener {

    private ObjectMapper objectMapper;

    public MessageListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @JmsListener(destination = "jms/queue/message", concurrency = "15")
    public void onMessageReceived(TextMessage message) throws JMSException, JsonProcessingException {
        MyMessage myMessage = objectMapper.readValue(message.getText(), MyMessage.class);
        log.info("code: " + myMessage.getCode() + "; " + "message: " + myMessage.getMessage());
    }

}
