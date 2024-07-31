package com.zzhow.tliasitheima.controller;

import com.zzhow.tliasitheima.anno.Log;
import com.zzhow.tliasitheima.pojo.Emp;
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
    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除 id = {} 的员工", ids);

        empService.delete(ids);

        return Result.success();
    }

    /**
     * 添加员工
     *
     * @param emp
     * @return null
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("添加员工：{}", emp);

        empService.add(emp);

        return Result.success();
    }

    /**
     * 根据 ID 查询员工信息
     *
     * @param id-员工 ID
     * @return JSON-员工信息
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据 ID 查询员工信息：id = {}", id);

        Emp emp = empService.getById(id);

        return Result.success(emp);
    }

    /**
     * 修改员工信息
     * @param emp-员工信息
     * @return null
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工信息：emp = {}", emp);

        empService.update(emp);

        return Result.success();
    }
}
