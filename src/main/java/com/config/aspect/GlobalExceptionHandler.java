package com.config.aspect;

import com.config.util.json.JsonUtil;
import com.config.util.web.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;


/**
 * Created by LiNan on 2018-04-09.
 * Description:系统全局异常跳转
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletResponse httpServletResponse){
        WebUtil.out(httpServletResponse, JsonUtil.createOperaStr(true,"GlobalException","网站正在修复中，对您造成的不便深感抱歉"));
    }
}
