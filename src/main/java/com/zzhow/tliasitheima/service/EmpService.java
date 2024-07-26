package com.zzhow.tliasitheima.service;

import com.zzhow.tliasitheima.pojo.Emp;
import com.zzhow.tliasitheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * @author ZZHow
 * @date 2024/7/25
 */
public interface EmpService {
    /**
     * 分页查询员工信息
     *
     * @param page
     * @param pageSize
     * @return PageBean-员工总数、员工信息
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 删除指定 ID 的员工
     *
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 添加员工
     *
     * @param emp
     */
    void add(Emp emp);
}
