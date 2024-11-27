package com.cyy.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: springAll
 * @description:
 * @author: 酷炫焦少
 * @create: 2024-11-27 19:55
 **/
@Data
@ConfigurationProperties(prefix = "cyy.blog")
public class ConfigBean {

    private String name;

    private String title;

    private String wholeTitle;

}
