package com.zzhow.tliasitheima.service.impl;

import com.zzhow.tliasitheima.mapper.DeptMapper;
import com.zzhow.tliasitheima.mapper.EmpMapper;
import com.zzhow.tliasitheima.pojo.Dept;
import com.zzhow.tliasitheima.service.DeptService;
import com.zzhow.tliasitheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ZZHow
 * @date 2024/7/25
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.selectAll();
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
        empMapper.deleteByDeptId(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public List<Dept> get(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
