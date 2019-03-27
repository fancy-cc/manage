package com.fw.manage.service.impl;

import com.fw.manage.entity.Customer;
import com.fw.manage.dao.CustomerMapperDao;
import com.fw.manage.service.CustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapperDao, Customer> implements CustomerService {

    @Resource
    private CustomerMapperDao customerMapperDao;

    public HttpResult insertSelective(Customer customer) {
        int count = customerMapperDao.insertSelective(customer);
        if (count == 1) {
            return HttpResult.success(customer.getId(), "用户创建成功");
        }
        return HttpResult.failure(500, "用户创建失败");
    }
}
