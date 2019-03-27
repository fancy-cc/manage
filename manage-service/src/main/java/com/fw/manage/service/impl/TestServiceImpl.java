package com.fw.manage.service.impl;

import com.fw.manage.entity.Test;
import com.fw.manage.dao.TestMapperDao;
import com.fw.manage.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fw.manage.web.domain.HttpResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author MP-ML
 * @since 2019-03-27
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapperDao, Test> implements TestService {

    @Resource
    private TestMapperDao testMapperDao;

    public HttpResult insertSelective(Test test) {
        int count = testMapperDao.insertSelective(test);
        if (count == 1) {
            return HttpResult.success(test.getId(), "用户创建成功");
        }
        return HttpResult.failure(500, "用户创建失败");
    }
}
