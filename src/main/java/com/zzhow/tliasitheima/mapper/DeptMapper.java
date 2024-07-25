package com.zzhow.tliasitheima.mapper;

import com.zzhow.tliasitheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZZHow
 * @date 2024/7/25
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询所有员工数据
     *
     * @return List<Dept>员工数据
     */
    @Select("select * from dept")
    List<Dept> selectAll();

    /**
     * 删除指定 ID 的部门
     *
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
}
