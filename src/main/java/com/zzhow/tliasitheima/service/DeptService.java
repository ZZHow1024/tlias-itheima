package com.zzhow.tliasitheima.service;

import com.zzhow.tliasitheima.pojo.Dept;

import java.util.List;

/**
 * @author ZZHow
 * @date 2024/7/25
 */
public interface DeptService {
    /**
     * 查询全部部门数据
     *
     * @return List<Dept>全部部门数据
     */
    List<Dept> findAll();

    /**
     * 删除指定 ID 的部门
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 添加部门
     *
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据 ID 查询部门信息
     *
     * @param id
     * @return (List<Dept>)指定 ID 的部门数据
     */
    List<Dept> get(Integer id);
}
