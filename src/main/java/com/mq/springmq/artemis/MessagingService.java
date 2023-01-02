package com.mq.springmq.artemis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by wqg on 2022/11/27.
 */
@Component
@Slf4j
public class MessagingService {

    private JmsTemplate jmsTemplate;

    private ObjectMapper objectMapper;

    public MessagingService(JmsTemplate jmsTemplate, ObjectMapper objectMapper) {
        this.jmsTemplate = jmsTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(String destinationName, Object message) throws JsonProcessingException {
        log.info("start send message...");
        String txtMessage = objectMapper.writeValueAsString(message);
        try {
            jmsTemplate.send(destinationName, session -> session.createTextMessage(txtMessage));
        } catch (JmsException e) {
            log.error("send message failed.");
        }

        log.info("send message success.");
    }




}
