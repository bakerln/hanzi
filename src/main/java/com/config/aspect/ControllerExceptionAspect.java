package com.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by LiNan on 2018-04-12.
 * Description: controller层异常拦截记录
 */
@Aspect
public class ControllerExceptionAspect {
    private static Logger logger = LoggerFactory.getLogger("controllerLog");

    @AfterThrowing(value = "execution (* com.*.controller.*.*(..))", throwing = "e")
    public void loggingException(JoinPoint joinPoint, Exception e) {
        // 拦截的实体类
        Object target = joinPoint.getTarget(); // 拦截的方法名称
        String methodName = joinPoint.getSignature().getName();
        logger.error("Controller实体类:" + target);
        logger.error("方法名:" + methodName);
        logger.error("异常类名:" + joinPoint.getSignature().getName().getClass());
        // 得到被拦截方法参数，并打印
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            logger.error("抛异常拦截:  被拦截到的方法参数: 第" + i + "个,value: " + args[i]);
        }
        logger.error("异常类型: " + e.getClass());
        logger.error("异常信息: " + e.getMessage());
    }
}
