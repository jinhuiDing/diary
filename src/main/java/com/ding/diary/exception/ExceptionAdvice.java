package com.ding.diary.exception;

import com.ding.diary.util.ResponseUtils;
import com.ding.diary.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @description: ExceptionAdvice
 * @author: ding
 * @date: 2019/10/18 15:24
 * @version: 1.0
 */

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {


    @ResponseStatus(code = HttpStatus.OK)
    @ExceptionHandler(CustomException.class)
    public ResponseVO customException(Exception e){
        return ResponseUtils.error(e.getMessage());
    }
    @ResponseStatus(code = HttpStatus.OK)
    @ExceptionHandler(UnLoginException.class)
    public ResponseVO unLoginException(Exception e){
        ResponseVO responseVO = new ResponseVO();
        return ResponseUtils.forbidden();
    }
}
