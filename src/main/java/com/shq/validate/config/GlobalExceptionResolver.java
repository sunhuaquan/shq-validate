package com.shq.validate.config;

import com.shq.validate.exception.ValidateException;
import com.shq.validate.vo.ResultJson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunhuaquan
 * @Title: GlobalExceptionResolver
 * @ProjectName shq-validate
 * @Description: TODO
 * @date 2019/3/3113:28
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);
    /**
     * @param ex
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResultJson exception(Exception ex) {

        logger.error("---------GlobalExceptionResolver------------",ex);
        if (ex instanceof ValidateException) {
            return ResultJson.error(ex.getMessage());
        }
        return ResultJson.error("未知错误");
    }

}
