package com.zzhow.tliasitheima.controller;

import com.zzhow.tliasitheima.pojo.PageBean;
import com.zzhow.tliasitheima.pojo.Result;
import com.zzhow.tliasitheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZZHow
 * @date 2024/7/25
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 分页查询员工信息
     *
     * @param page
     * @param pageSize
     * @return JSON-员工总数、员工信息
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询，page = {}，pageSize = {}", page, pageSize);

        PageBean pageBean = empService.page(page, pageSize);

        return Result.success(pageBean);
    }
}
