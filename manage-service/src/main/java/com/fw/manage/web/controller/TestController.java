package com.fw.manage.web.controller;


import com.fw.manage.entity.Test;
import com.fw.manage.service.TestService;
import com.fw.manage.web.domain.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 测试表 前端控制器
 * </p>
 *
 * @author MP-ML
 * @since 2019-03-27
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @PostMapping("/insertSelective")
    public HttpResult insertSelective(Test test) {
        if (test == null) {
            HttpResult.failure(400, "缺少参数");
        }
        HttpResult httpResult = testService.insertSelective(test);
        return httpResult;
    }
}

