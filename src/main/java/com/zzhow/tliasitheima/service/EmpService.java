package com.zzhow.tliasitheima.service;

import com.zzhow.tliasitheima.mapper.EmpMapper;
import com.zzhow.tliasitheima.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;

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
    public PageBean page(Integer page, Integer pageSize);
}
