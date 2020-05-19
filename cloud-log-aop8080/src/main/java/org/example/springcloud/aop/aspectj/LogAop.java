package org.example.springcloud.aop.aspectj;

import cn.hutool.json.JSONUtil;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author: songhl
 * @datetime: 2020/5/19 14:10:14
 * @description:
 */
@Slf4j
@Aspect
@Component
public class LogAop {
    private static final String START_TIME = "request-start";

    /**
     * 切入点
     */
    @Pointcut("execution(public * org.example.springcloud.controller.*Controller.*(..))")
    public void log() {
    }

    /**
     * 前置操作
     *
     * @param joinPoint
     */
    @Before("log()")
    public void beforeLog(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(servletRequestAttributes).getRequest();
        log.info("【请求 URL】：{}", request.getRequestURL());
        log.info("【请求 IP】:{}", request.getRemoteAddr());
        log.info("【请求类名】：{}, 【请求方法名】：{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        log.info("【请求参数】：{}", JSONUtil.toJsonStr(request.getParameterMap()));
        Long startTime = System.currentTimeMillis();
        request.setAttribute(START_TIME, startTime);
    }

    /**
     * 环绕操作
     *
     * @param proceedingJoinPoint
     */
    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        log.info("【返回值】：{}", JSONUtil.toJsonStr(result));
        return result;
    }

    /**
     * 后置操作
     */
    @AfterReturning("log()")
    public void afterReturning() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(servletRequestAttributes).getRequest();
        Long startTime = (Long) request.getAttribute(START_TIME);
        Long endTime = System.currentTimeMillis();
        log.info("【请求耗时】：{}毫秒", endTime - startTime);
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        log.info("【浏览器类型】：{}, 【操作系统】：{}, 【原始User-Agent】:{}", userAgent.getBrowser(), userAgent.getOperatingSystem(), header);
    }
}
