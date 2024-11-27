package com.cyy.config.controller;

import com.cyy.config.bean.BlogProperties;
import com.cyy.config.bean.ConfigBean;
import com.cyy.config.bean.TestConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springAll
 * @description:
 * @author: 酷炫焦少
 * @create: 2024-11-27 19:42
 **/
@RestController
public class IndexController {

    @Autowired
    private BlogProperties blogProperties;

    @Autowired
    private ConfigBean configBean;

    @Autowired
    private TestConfigBean testConfigBean;

    @RequestMapping("/blog")
    public String blog() {
        return "name:" + blogProperties.getName()
                + "title:" + blogProperties.getTitle();
    }

    @RequestMapping("/config")
    public String config() {
        return "name:" + configBean.getName()
                + " title:" + configBean.getTitle()
                + " wholeTime:" + configBean.getWholeTitle() ;
    }

    @RequestMapping("/test")
    public String test() {
        return "name:" + testConfigBean.getName()
                + " title:" + testConfigBean.getTitle();
    }

}
