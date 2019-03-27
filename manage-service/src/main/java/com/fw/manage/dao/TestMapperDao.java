package com.fw.manage.dao;

import com.fw.manage.entity.Test;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 测试表 Mapper 接口
 * </p>
 *
 * @author MP-ML
 * @since 2019-03-27
 */
public interface TestMapperDao extends BaseMapper<Test> {

    int insertSelective(Test test);
}
