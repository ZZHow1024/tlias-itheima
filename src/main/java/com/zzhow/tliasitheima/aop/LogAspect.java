package com.zzhow.tliasitheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.zzhow.tliasitheima.mapper.OperateLogMapper;
import com.zzhow.tliasitheima.pojo.OperateLog;
import com.zzhow.tliasitheima.util.JWTUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author ZZHow
 * @date 2024/7/31
 */
@Slf4j
@Aspect
@Component
public class LogAspect {
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Autowired
    private HttpServletRequest httpServletRequest;


    public LogAspect(OperateLogMapper operateLogMapper) {
        this.operateLogMapper = operateLogMapper;
    }

    @Around("@annotation(com.zzhow.tliasitheima.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String token = httpServletRequest.getHeader("token");
        Claims claims = jwtUtils.parseToken(token);
        //操作人 ID
        Integer operateUser = (Integer) claims.get("id");

        //操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        //操作类名
        String className = joinPoint.getTarget().getClass().getName();

        //操作方法名
        String methodName = joinPoint.getSignature().getName();

        //操作方法参数
        String methodParams = Arrays.toString(joinPoint.getArgs());

        //方法返回值
        long begin = System.currentTimeMillis();
            //调用原始目标方法运行
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        String returnValue = JSONObject.toJSONString(result);

        //操作耗时
        long costTime = end - begin;

        //构建 OperateLog 对象
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);

        operateLogMapper.insert(operateLog);

        log.info("AOP 中记录操作日志：operateLog = {}", operateLog);

        return result;
    }
}
