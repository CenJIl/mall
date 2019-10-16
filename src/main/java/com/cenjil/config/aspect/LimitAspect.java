package com.cenjil.config.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author CenJIl
 * @date 2019/9/9 10:05
 */

@Aspect
@Component
public class LimitAspect {
    private Log logger = LogFactory.getLog(this.getClass());

    @Value("${spring.datasource.url.master}")
    private String master;
    @Value("${spring.datasource.url.servants}")
    private String servants;


    @Around("@annotation(com.cenjil.config.annotation.Limit)")
    public Object around(ProceedingJoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) (Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))).getRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        long startTime = System.currentTimeMillis();

        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            long endTime = System.currentTimeMillis();
            logger.error("时间: " + (endTime - startTime));
        }
        return null;
    }

    @AfterThrowing(pointcut = "@annotation(com.cenjil.config.annotation.Limit)", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        logger.error("捕获到异常 : " + e.getMessage());
    }


    @Around("@annotation(com.cenjil.config.annotation.Limit)")
    public Object around(JoinPoint joinPoint) {

        return null;
    }
}
