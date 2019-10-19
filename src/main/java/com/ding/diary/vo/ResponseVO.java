package com.ding.diary.vo;

import lombok.Data;

/**
 * @description: ResponseVO
 * @author: ding
 * @date: 2019/10/18 14:47
 * @version: 1.0
 */

@Data
public class ResponseVO {
    private String msg;

    private Boolean success;
    private Integer code;

    private Object data;
}
