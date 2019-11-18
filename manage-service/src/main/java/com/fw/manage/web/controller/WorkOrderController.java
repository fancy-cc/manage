package com.fw.manage.web.controller;

import com.fw.manage.entity.WorkOrder;
import com.fw.manage.service.WorkOrderService;
import com.fw.manage.web.domain.HttpResult;
import com.fw.manage.web.domain.PageResultSet;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 测试表 前端控制器
 * </p>
 *
 * @author MP-ML
 * @since 2019-03-27
 */
@RestController
@RequestMapping("/work/order")
public class WorkOrderController {

    @Autowired
    private WorkOrderService workOrderService;

    @PostMapping("/add")
    public HttpResult add(@RequestBody WorkOrder workOrder) {
        if (workOrder == null || StringUtils.isBlank(workOrder.getAddress()) || StringUtils.isBlank(workOrder.getMobile())
                || workOrder.getServiceTime() == null || workOrder.getType() == null) {
            return HttpResult.failure("完善信息后重新提交");
        }

        HttpResult httpResult = workOrderService.add(workOrder);
        return httpResult;
    }

    @GetMapping("/list")
    public HttpResult list(@RequestParam Integer pageSize, @RequestParam Integer currentPageNo) {
        List<WorkOrder> list = workOrderService.list(pageSize, currentPageNo);
        int count = workOrderService.count();
        PageResultSet pageResultSet = new PageResultSet();
        pageResultSet.setList(list);
        pageResultSet.setAllRow(count);
        pageResultSet.setCurrentPageNo(currentPageNo);
        pageResultSet.setPageSize(pageSize);
        return HttpResult.success(pageResultSet);
    }

    @GetMapping("/commitList")
    public HttpResult commitList(@RequestParam Integer pageSize, @RequestParam Integer currentPageNo) {
        List<WorkOrder> list = workOrderService.commitList(pageSize, currentPageNo);
        int count = workOrderService.count();
        PageResultSet pageResultSet = new PageResultSet();
        pageResultSet.setList(list);
        pageResultSet.setAllRow(count);
        pageResultSet.setCurrentPageNo(currentPageNo);
        pageResultSet.setPageSize(pageSize);
        return HttpResult.success(pageResultSet);
    }

    @PostMapping("/commit")
    public HttpResult commit(@RequestParam Long id) {
        if (id == null || id < 0) {
            return HttpResult.failure("参数错误");
        }

        HttpResult httpResult = workOrderService.commit(id);
        return httpResult;
    }

    @PostMapping("/reserve")
    public HttpResult reserve(@RequestParam Long id) {
        if (id == null || id < 0) {
            return HttpResult.failure("参数错误");
        }

        HttpResult httpResult = workOrderService.reserve(id);
        return httpResult;
    }

    @GetMapping("/detail")
    public HttpResult detail(@RequestParam Long id) {
        if (id == null || id < 0) {
            return HttpResult.failure("参数错误");
        }

        HttpResult<WorkOrder> httpResult = workOrderService.detail(id);
        return httpResult;
    }

}

