package com.zzhow.tliasitheima.service;

import com.zzhow.tliasitheima.pojo.Dept;

import java.util.List;

/**
 * @author ZZHow
 * @date 2024/7/25
 */
public interface DeptService {
    /**
     * 查询所有部门信息
     *
     * @return List<Dept>员工数据
     */
    List<Dept> findAll();
}
