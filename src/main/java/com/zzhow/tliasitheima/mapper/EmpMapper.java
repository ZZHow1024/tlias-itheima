package com.zzhow.tliasitheima.mapper;

import com.zzhow.tliasitheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
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
/*   @Select("select id, username, password, name, gender, image, job, entry_date, dept_id, create_time, update_time" +
            " from emp")*/
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 删除指定 ID 的员工
     *
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 添加部门
     *
     * @param emp
     */
    void insert(Emp emp);

    /**
     * 根据 ID 查询员工信息
     *
     * @param id-员工 ID
     * @return Emp-员工信息
     */
    Emp selectById(Integer id);

    /**
     * 修改员工信息
     *
     * @param emp-员工信息
     */
    void update(Emp emp);
}
