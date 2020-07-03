package com.ding.diary.conf;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: DirectRabbitConfig
 * @author: ding
 * @date: 2019/11/4 10:36
 * @version: 1.0
 */

@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue directQueue(){
        return new Queue("message", true);
    }

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange("diary", true,true);
    }

    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(directQueue()).to(exchange()).with("diary-routingKey");
    }
}
