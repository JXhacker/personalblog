package com.wanzhiwen.blog.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author wanzhiwen
 * @time 2018/11/29
 */

@Aspect
@Component
@Slf4j
public class ControllerLog {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Pointcut(value = "execution(public * com.wanzhiwen.blog.controller..*(..))")
    private void controllerLog() {
    }

    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            log.info(" URL: " + request.getRequestURL().toString());
            log.info(" ARGS：" + Arrays.toString(joinPoint.getArgs()));
        } else {
            String username = (String) session.getAttribute("username");
            log.info("USERNAME: "+username);
            log.info(" URL: " + request.getRequestURL().toString());
            log.info(" ARGS：" + Arrays.toString(joinPoint.getArgs()));
        }
    }

}
