package com.xiaoke;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@NacosPropertySource(dataId = "test", autoRefreshed = true)
public class SpringbootNacosApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootNacosApplication.class, args);
        // 测试获取配置类和工具类，与Nacos无关
        TestConfig nacosConfig = (TestConfig) ctx.getBean("testConfig");
        System.out.println(nacosConfig);
        TestUtil nacosUtil = (TestUtil) ctx.getBean("testUtil");
        System.out.println(nacosUtil);
    }

}
