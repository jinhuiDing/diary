package com.ding.diary.util;


import com.ding.diary.enu.ResponseCodeEnum;
import com.ding.diary.vo.ResponseVO;

/**
 * @description: ResponseUtils
 * @author: ding
 * @date: 2019/10/18 14:48
 * @version: 1.0
 */


public class ResponseUtils {

    public static ResponseVO success(Object data) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ResponseCodeEnum.SUCCESS.getCode());
        responseVO.setData(data);
        responseVO.setMsg(ResponseCodeEnum.SUCCESS.getMsg());
        responseVO.setSuccess(true);
        return responseVO;
    }

    public static ResponseVO success() {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ResponseCodeEnum.SUCCESS.getCode());
        responseVO.setMsg(ResponseCodeEnum.SUCCESS.getMsg());
        responseVO.setSuccess(true);
        return responseVO;
    }
    public static ResponseVO error(String message) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ResponseCodeEnum.ERROR.getCode());
        responseVO.setData(null);
        responseVO.setMsg(ResponseCodeEnum.ERROR.getMsg());
        responseVO.setSuccess(false);
        return responseVO;
    }
    public static ResponseVO forbidden() {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ResponseCodeEnum.FORBIDDEN.getCode());
        responseVO.setData(null);
        responseVO.setMsg(ResponseCodeEnum.FORBIDDEN.getMsg());
        responseVO.setSuccess(false);
        return responseVO;
    }
}
