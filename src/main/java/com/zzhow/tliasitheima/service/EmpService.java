package com.zzhow.tliasitheima.service;

import com.zzhow.tliasitheima.pojo.PageBean;

import java.time.LocalDate;

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
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
}
