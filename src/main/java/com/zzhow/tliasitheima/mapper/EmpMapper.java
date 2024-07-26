package com.zzhow.tliasitheima.mapper;

import com.zzhow.tliasitheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZZHow
 * @date 2024/7/25
 */
@Mapper
public interface EmpMapper {
    /**
     * 查询总记录数
     *
     * @return Long-总记录数
     */
    @Select("select count(*) from emp")
    Long count();

    /**
     * 分页查询，获取列表数据
     *
     * @param start
     * @param pageSize
     * @return List<Emp>-分页列表数据
     */
/*   @Select("select id, username, password, name, gender, image, job, entry_date, dept_id, create_time, update_time" +
            " from emp limit #{start}, #{pageSize}")
     List<Emp> page(Integer start, Integer pageSize);*/

    /**
     * 分页查询，获取列表数据（使用 PageHelper）
     *
     * @return List<Emp>-分页列表数据
     */
    @Select("select id, username, password, name, gender, image, job, entry_date, dept_id, create_time, update_time" +
            " from emp")
    List<Emp> list();
}
