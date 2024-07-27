package com.zzhow.tliasitheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzhow.tliasitheima.mapper.EmpMapper;
import com.zzhow.tliasitheima.pojo.Emp;
import com.zzhow.tliasitheima.pojo.PageBean;
import com.zzhow.tliasitheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ZZHow
 * @date 2024/7/25
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

/*  @Override
    public PageBean page(Integer page, Integer pageSize) {
        //1. 获取总记录数
        Long count = empMapper.count();

        //2. 获取分页查询结果列表
        List<Emp> empList = empMapper.page((page - 1) * pageSize, pageSize);

        //3. 封装 PageBean 对象
        return new PageBean(count, empList);
    }*/

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        //2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        //3. 封装 PageBean 对象
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.selectById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
}
