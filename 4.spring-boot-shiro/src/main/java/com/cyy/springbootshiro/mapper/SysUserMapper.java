package com.cyy.springbootshiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyy.springbootshiro.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: sa-token
 * @description:
 * @author: 酷炫焦少
 * @create: 2024-11-22 20:54
 **/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
