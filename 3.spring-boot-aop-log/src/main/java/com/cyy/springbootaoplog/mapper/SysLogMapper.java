package com.cyy.springbootaoplog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyy.springbootaoplog.annotation.AutoFill;
import com.cyy.springbootaoplog.annotation.Log;
import com.cyy.springbootaoplog.domain.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @program: springAll
 * @description:
 * @author: 酷炫焦少
 * @create: 2024-11-27 21:35
 **/
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {

    @AutoFill
    @Select("insert into sys_log (id, username, operation, time, method, params, ip, create_time) " +
            "values" +
            " (#{id}, #{username}, #{operation}, #{time}, #{method}, #{params}, #{ip}, #{createTime})")
    public void saveLog(SysLog sysLog);

}
