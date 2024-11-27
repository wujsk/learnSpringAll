package com.cyy.springbootaoplog.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyy.springbootaoplog.domain.SysLog;
import com.cyy.springbootaoplog.mapper.SysLogMapper;
import com.cyy.springbootaoplog.service.ISysLogService;
import org.springframework.stereotype.Service;

/**
 * @program: springAll
 * @description:
 * @author: 酷炫焦少
 * @create: 2024-11-27 21:34
 **/
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {
}
