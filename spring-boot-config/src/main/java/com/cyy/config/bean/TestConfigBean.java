package com.cyy.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: springAll
 * @description:
 * @author: 酷炫焦少
 * @create: 2024-11-27 20:04
 **/
@Data
@ConfigurationProperties(prefix = "cyy.test")
@PropertySource("classpath:test.properties") // 读取外部配置文件，需要加上@Component
@Component
public class TestConfigBean {

    private String name;

    private String title;

}
