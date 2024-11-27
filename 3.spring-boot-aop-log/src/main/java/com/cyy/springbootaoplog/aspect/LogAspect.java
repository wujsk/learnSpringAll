package com.cyy.springbootaoplog.aspect;

import cn.hutool.core.util.StrUtil;
import com.cyy.springbootaoplog.annotation.Log;
import com.cyy.springbootaoplog.domain.SysLog;
import com.cyy.springbootaoplog.mapper.SysLogMapper;
import com.cyy.springbootaoplog.service.ISysLogService;
import com.cyy.springbootaoplog.util.HttpContextUtil;
import com.cyy.springbootaoplog.util.IpUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @program: springAll
 * @description:
 * @author: 酷炫焦少
 * @create: 2024-11-27 21:23
 **/
@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Pointcut("@annotation(com.cyy.springbootaoplog.annotation.Log)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint point) {
        long begin = System.currentTimeMillis();
        try {
            // 先去执行目标方法
            point.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        // 执行时长
        long time = System.currentTimeMillis() - begin;
        // 保存日志
        saveLog(time, point);
    }

    private void saveLog(long time, ProceedingJoinPoint point) {
        SysLog sysLog = new SysLog();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        // 获取使用此注解的类
        String className = point.getTarget().getClass().getName();
        sysLog.setMethod(className + ":" + method.getName());
        Log annotation = method.getAnnotation(Log.class);
        String operation = annotation.value();
        if (StrUtil.isNotBlank(operation)) {
            sysLog.setOperation(operation);
        }
        // 请求方法参数值
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        Object[] args = point.getArgs();
        // 请求方法参数名称
        if (!Objects.isNull(args) && args.length != 0) {
            String[] parameterNames = pnd.getParameterNames(method);
            String params =  "";
            for (int i = 0; i < args.length; i++) {
                params += parameterNames[i] + ":" + args[i] + "  ";
            }
            sysLog.setParams(params);
        }
        HttpServletRequest httpServletRequest = HttpContextUtil.getHttpServletRequest();
        String ipAddr = IpUtil.getIpAddr(httpServletRequest);
        sysLog.setIp(ipAddr);
        sysLog.setUsername("admin");
        sysLog.setTime((int) time);
        sysLogMapper.saveLog(sysLog);
    }

}
