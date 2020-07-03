package com.ding.diary.controller;


import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

//@SpringBootTest(classes = DiaryApplication.class)
//@RunWith(SpringRunner.class)

public class SysDiaryControllerTest {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void demo() {
        System.out.println("new Date() = " + new Date());
        rabbitTemplate.convertAndSend("diary", "diary-routingKey", "发送第一条信息");
    }

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i <= 200; i++) { // 质数
            for (int k = 2; k <= i; k++) { // 除数
                // 排除所有在 i=k 之前 能被k整除(余数为0)的数
                if (i % k == 0 && i != k) {
                    break;
                }
                // 输出所有在 i=k 且 i%k=0的数
                if (i % k == 0 && i == k) {
                    System.out.println(i);
                    sum += i;
                }
            }
        }
        System.out.println("sum=" + sum);
    }
}
