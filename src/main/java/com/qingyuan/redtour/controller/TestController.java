package com.qingyuan.redtour.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试部署（前端忽略该接口）
 * @Author: qyl
 * @Date: 2021/4/29 19:35
 */
@RestController
public class TestController {

    /**
     * Test connection
     * @return
     */
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
