package com.fw.manage.web.controller;


import com.fw.manage.entity.Customer;
import com.fw.manage.service.CustomerService;
import com.fw.manage.web.domain.HttpResult;
import com.fw.manage.web.domain.PageResultSet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 测试表 前端控制器
 * </p>
 *
 * @author MP-ML
 * @since 2019-03-27
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @PostMapping("/insertSelective")
    public HttpResult insertSelective(Customer customer) {
        if (customer == null) {
            HttpResult.failure(400, "缺少参数");
        }
        HttpResult httpResult = customerService.insertSelective(customer);
        return httpResult;
    }

    @GetMapping("/list")
    public HttpResult list() {
        List<Customer> list = customerService.list();
        PageResultSet pageResultSet = new PageResultSet();
        pageResultSet.setList(list);
        pageResultSet.setAllRow(list.size());
        pageResultSet.setPageSize(10);
        pageResultSet.setCurrentPageNo(1);
        return HttpResult.success(pageResultSet);
    }
}

