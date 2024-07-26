package com.zzhow.tliasitheima.mapper;

import com.zzhow.tliasitheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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
     * 查询全部部门数据
     *
     * @return (List<Dept>)全部部门数据
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

    /**
     * 添加部门
     *
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) VALUES(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    /**
     * 根据 ID 查询部门信息
     *
     * @param id
     * @return (List<Dept>)指定 ID 的部门数据
     */
    @Select("select * from dept where id = #{id}")
    List<Dept> selectById(Integer id);
}
