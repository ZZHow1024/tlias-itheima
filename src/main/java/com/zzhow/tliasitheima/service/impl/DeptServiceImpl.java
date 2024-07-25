package com.zzhow.tliasitheima.service.impl;

import com.zzhow.tliasitheima.mapper.DeptMapper;
import com.zzhow.tliasitheima.pojo.Dept;
import com.zzhow.tliasitheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZZHow
 * @date 2024/7/25
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.selectAll();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }
}
