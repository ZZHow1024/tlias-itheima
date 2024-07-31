package com.zzhow.tliasitheima.mapper;

import com.zzhow.tliasitheima.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZZHow
 * @date 2024/7/31
 */
@Mapper
public interface OperateLogMapper {

    @Insert("insert into operate_log (operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time)" +
            "VALUES (#{operateUser}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime})")
    public void insert(OperateLog operateLog);
}
