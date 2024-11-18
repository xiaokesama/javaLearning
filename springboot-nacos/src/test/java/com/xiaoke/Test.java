package com.xiaoke;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

public class Test {
    public static void main(String[] args) {
        try {
            String serverAddr = "127.0.0.1:8848";
            String dataId = "test";
            String group = "DEFAULT_GROUP";

            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            properties.put("dataId", dataId);
            properties.put("group", group);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            System.out.println(content);

            configService.addListener(dataId, group, new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("receiveConfigInfo:" + configInfo);
                }
                @Override
                public Executor getExecutor() {
                    return null;
                }
            });

            Thread.sleep(Long.MAX_VALUE);

        } catch (NacosException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
