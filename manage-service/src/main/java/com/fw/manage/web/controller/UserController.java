package com.fw.manage.web.controller;

import com.fw.manage.entity.User;
import com.fw.manage.service.UserService;
import com.fw.manage.web.domain.HttpResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    public HttpResult insertUser(@RequestBody User user) {
        if (user == null) {
           return HttpResult.failure("用户信息填写不完整。");
        }
        HttpResult httpResult = userService.insert(user);
        return httpResult;
    }

    public HttpResult selectById(@RequestParam Long id) {
        if (id > 0) {
            HttpResult httpResult = userService.select(id);
            return httpResult;
        } else {
            return HttpResult.failure("参数错误。");
        }
    }
}
