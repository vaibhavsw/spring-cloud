package com.ghost.order.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeAspect {

    @Around("@annotation(com.ghost.order.aspect.TrackExecTime)")
    public Object logExecTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = pjp.proceed();

        long end = System.currentTimeMillis();

        log.info(String.format("Target [{%s}] took [{%s}] time to execute", pjp.getSignature(), (end - start)));

        return proceed;
    }
}
