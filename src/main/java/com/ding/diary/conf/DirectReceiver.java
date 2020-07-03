package com.ding.diary.conf;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description: DirectReceiver
 * @author: ding
 * @date: 2019/11/4 11:27
 * @version: 1.0
 */

@Component
public class DirectReceiver {

    @RabbitListener(queues = "message")
    @RabbitHandler
    public  void process(String map){
        System.out.println("map = " + map);
    }
}
