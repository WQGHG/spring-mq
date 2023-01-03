package com.mq.springmq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mq.springmq.model.MyMessage;
import com.mq.springmq.artemis.JmsMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by wqg on 2022/11/27.
 */
@Controller
@Slf4j
@RequestMapping("/jms")
public class JmsMessageController {

    @Resource
    JmsMessageService jmsMessagingService;

    @GetMapping(value = "/send")
    @ResponseBody
    public String sendMessage(@RequestParam(value = "code", required = false) String code) throws JsonProcessingException {
        MyMessage myMessage = new MyMessage(code,"artemis myMessage test");
        jmsMessagingService.sendMessage("jms/queue/message", myMessage);

        return "200";
    }


}
