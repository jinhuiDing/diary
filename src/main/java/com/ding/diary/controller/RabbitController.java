package com.ding.diary.controller;

import com.ding.diary.anno.Anonymous;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: RabbitController
 * @author: ding
 * @date: 2019/11/4 11:23
 * @version: 1.0
 */


@RestController("rabbit")
public class RabbitController {

    @Autowired
    RabbitTemplate rabbitTemplate;


    @Anonymous
    @GetMapping("send")
    public void sendMessage(@RequestParam("message") String message){

        rabbitTemplate.convertAndSend("diary","diary-routingKey",message);

    }
}
