package com.fw.manage.dao;

import com.fw.manage.entity.User;

public interface UserMapper {
    int insert(User user);

    User selectById(Long id);
}
