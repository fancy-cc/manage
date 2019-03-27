package com.fw.manage.dao;

import com.fw.manage.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 测试表 Mapper 接口
 * </p>
 *
 * @author MP-ML
 * @since 2019-03-27
 */
public interface CustomerMapperDao extends BaseMapper<Customer> {

    int insertSelective(Customer customer);
}
