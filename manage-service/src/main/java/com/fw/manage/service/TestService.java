package com.fw.manage.service;

import com.fw.manage.entity.Test;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fw.manage.web.domain.HttpResult;

/**
 * <p>
 * 测试表 服务类
 * </p>
 *
 * @author MP-ML
 * @since 2019-03-27
 */
public interface TestService extends IService<Test> {

    HttpResult insertSelective(Test test);
}
