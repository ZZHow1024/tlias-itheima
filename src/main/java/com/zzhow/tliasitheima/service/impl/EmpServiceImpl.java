package com.zzhow.tliasitheima.service.impl;

import com.zzhow.tliasitheima.mapper.EmpMapper;
import com.zzhow.tliasitheima.pojo.Emp;
import com.zzhow.tliasitheima.pojo.PageBean;
import com.zzhow.tliasitheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZZHow
 * @date 2024/7/25
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        //1. 获取总记录数
        Long count = empMapper.count();

        //2. 获取分页查询结果列表
        List<Emp> empList = empMapper.page((page - 1) * pageSize, pageSize);

        //3. 封装 PageBean 对象
        PageBean pageBean = new PageBean(count, empList);

        return pageBean;
    }
}
