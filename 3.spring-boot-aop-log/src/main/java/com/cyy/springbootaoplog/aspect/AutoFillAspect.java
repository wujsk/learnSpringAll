package com.cyy.springbootaoplog.aspect;

import com.cyy.springbootaoplog.annotation.AutoFill;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @program: springAll
 * @description:
 * @author: 酷炫焦少
 * @create: 2024-11-27 23:18
 **/
@Aspect
@Component
public class AutoFillAspect {

    @Pointcut("@annotation(com.cyy.springbootaoplog.annotation.AutoFill)")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void autoFill(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Object[] args = point.getArgs();
        if (Objects.isNull(args) || args.length == 0) {
            return;
        }
        Object arg = args[0];
        Class<?> aClass = arg.getClass();
        LocalDateTime createTime = LocalDateTime.now();
        try {
            Method setCreateTime = aClass.getMethod("setCreateTime", LocalDateTime.class);
            setCreateTime.invoke(arg, createTime);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
