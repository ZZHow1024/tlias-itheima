package com.zzhow.tliasitheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zzhow.tliasitheima.pojo.Result;
import com.zzhow.tliasitheima.util.JWTUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author ZZHow
 * @date 2024/7/27
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. 获取请求 URL
        String url = request.getRequestURL().toString();
        log.info("拦截到请求：URL = {}", url);

        //2. 获取请求头中的 JWT 令牌(token)
        String token = request.getHeader("token");

        //3. 校验 JWT 令牌
        Claims claims = jwtUtils.parseToken(token);
        if(claims == null) {
            log.info("JWT 令牌校验未通过");
            response.getWriter().write(JSONObject.toJSONString(Result.unauthorized(), SerializerFeature.WriteMapNullValue));
            return false;
        }

        log.info("JWT 令牌校验通过，Interceptor 放行");
        return true;
    }
}
