package com.xiaoke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestUtil {

    @Autowired
    private TestConfig nacosConfig;

    public String getServerAddr() {
        System.out.println("NacosUtil.getServerAddr():" + nacosConfig.getServerAddr());
        return nacosConfig.getServerAddr();
    }
}
