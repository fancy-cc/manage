package com.fw.manage.service;

import com.fw.manage.entity.Customer;
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
public interface CustomerService extends IService<Customer> {

    HttpResult insertSelective(Customer customer);
}
