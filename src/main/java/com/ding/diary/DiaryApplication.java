package com.ding.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: DiraryApplication
 * @author: ding
 * @date: 2019/10/15 21:11
 * @version: 1.0
 */

@SpringBootApplication
@EnableSwagger2
public class DiaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiaryApplication.class, args);
    }
}
