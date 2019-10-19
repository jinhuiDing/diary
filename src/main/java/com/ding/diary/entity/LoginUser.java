package com.ding.diary.entity;

import lombok.Data;

/**
 * @description: User
 * @author: ding
 * @date: 2019/10/18 21:45
 * @version: 1.0
 */

@Data
public class LoginUser {
    private Long id;
    private String name;

    public LoginUser(String name,Long id) {
        this.id = id;
        this.name = name;
    }
}
