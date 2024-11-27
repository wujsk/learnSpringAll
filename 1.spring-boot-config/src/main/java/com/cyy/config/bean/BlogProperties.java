package com.cyy.config.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: springAll
 * @description:
 * @author: 酷炫焦少
 * @create: 2024-11-27 19:43
 **/
@Component
@Data
public class BlogProperties {

    @Value("${cyy.blog.name}")
    private String name;

    @Value("${cyy.blog.title}")
    private String title;

}
