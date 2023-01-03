package com.mq.springmq.controller;

import com.mq.springmq.model.MyMessage;
import com.mq.springmq.model.MyMessageFirst;
import com.mq.springmq.model.MyMessageSecond;
import com.mq.springmq.rabbitmq.RabbitMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by wqg on 2023/1/3.
 */
@Component
@Slf4j
@RequestMapping("rabbit")
public class RabbitMessageController {

    @Resource
    RabbitMessageService rabbitMessageService;

    @RequestMapping("/first")
    @ResponseBody
    public String sendFirstMessage(String code) {
        MyMessageFirst myMessage = new MyMessageFirst(code, "first exchange message");
        rabbitMessageService.sendFirstExchangeMessage(myMessage);
        log.info("send first exchange message success");
        return "200";
    }

    @RequestMapping("/second")
    @ResponseBody
    public String sendFirstMessage(@RequestParam(value = "code")String code,
                                   @RequestParam(value = "message") String message) {
        MyMessageSecond myMessage = new MyMessageSecond(code, message);
        rabbitMessageService.sendSecondExchangeMessage(myMessage);
        log.info("send second exchange message success");
        return "200";
    }

    @RequestMapping("default")
    @ResponseBody
    public String sendDefaultMessage(String code) {
        MyMessage myMessage = new MyMessage(code, "default exchange message");
        rabbitMessageService.sendDefaultExchangeMessage(myMessage);
        log.info("send default exchange message success");
        return "200";
    }

    @RequestMapping("delay")
    @ResponseBody
    public String sendDelayMessage(String code) {
        MyMessage myMessage = new MyMessage(code, " delay message");
        rabbitMessageService.sendDelayMessage(myMessage);
        log.info("send delay message success");
        return "200";
    }

}
