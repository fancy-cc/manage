package com.fw.manage.service;

import com.fw.manage.entity.User;
import com.fw.manage.web.domain.HttpResult;

public interface UserService {
    HttpResult insert(User user);

    HttpResult select(Long id);
}
