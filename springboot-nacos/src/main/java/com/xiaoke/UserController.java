package com.xiaoke;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @NacosValue(value = "${datasources.username}", autoRefreshed = true)
    private String username;

    @GetMapping("/username")
    public String getUsername() {
        return username;
    }
}
