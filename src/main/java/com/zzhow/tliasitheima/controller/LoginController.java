package com.zzhow.tliasitheima.controller;

import com.zzhow.tliasitheima.pojo.Emp;
import com.zzhow.tliasitheima.pojo.Result;
import com.zzhow.tliasitheima.service.EmpService;
import com.zzhow.tliasitheima.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZZHow
 * @date 2024/7/27
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmpService empService;
    @Autowired
    private JWTUtils jwtUtils;

    /**
     * 员工登录
     *
     * @param emp-员工信息
     * @return 登录信息
     */
    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录：{}", emp);

        Emp login = empService.login(emp);
        if (login != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", login.getId());
            claims.put("username", login.getUsername());
            claims.put("name", login.getName());

            log.info("登录成功：username = {}", emp.getUsername());

            return Result.loginSuccessful(jwtUtils.generateToken(claims));
        }

        log.info("登录失败：username = {}", emp.getUsername());
        return Result.loginFailed();
    }
}
