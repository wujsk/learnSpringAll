package com.cyy.springbootshiro.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: sa-token
 * @description:
 * @author: 酷炫焦少
 * @create: 2024-11-22 21:37
 **/
@Setter
@Getter
@Builder
public class SysUserDTO {

    private String username;

    private String password;

}
