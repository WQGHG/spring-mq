package com.mq.springmq;

import com.mq.springmq.artemis.JmsMessageListener;
import com.mq.springmq.artemis.JmsMessageService;
import com.mq.springmq.controller.JmsMessageController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                JmsMessageListener.class,
                JmsMessageService.class,
                JmsMessageController.class
        })
})
public class SpringMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMqApplication.class, args);
    }

}
