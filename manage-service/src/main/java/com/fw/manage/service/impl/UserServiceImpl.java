package com.fw.manage.service.impl;

import com.fw.manage.dao.UserMapper;
import com.fw.manage.entity.User;
import com.fw.manage.service.UserService;
import com.fw.manage.web.domain.HttpResult;
import com.fw.manage.web.domain.PageResultSet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public HttpResult insert(User user) {
        int count = userMapper.insert(user);
        if (count == 1) {
            return HttpResult.success(user.getId(),"成功创建新用户");
        } else {
            return HttpResult.failure(500, "用户创建失败。");
        }
    }

    @Override
    public HttpResult select(Long id) {
        User user = userMapper.selectById(id);
        if (user != null) {
            return HttpResult.success(user, 200);
        } else {
            return HttpResult.failure("没有查询到相关用户。");
        }
    }
}
