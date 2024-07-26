package com.zzhow.tliasitheima.controller;

import com.zzhow.tliasitheima.pojo.PageBean;
import com.zzhow.tliasitheima.pojo.Result;
import com.zzhow.tliasitheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询：page = {}, pageSize = {}, name = {}, gender = {}, begin = {}, end = {}",
                page, pageSize, name, gender, begin, end);

        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);

        return Result.success(pageBean);
    }

    /**
     * 删除指定 ID 的员工
     *
     * @param ids
     * @return null
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除 id = {} 的员工", ids);

        empService.delete(ids);

        return Result.success();
    }
}
