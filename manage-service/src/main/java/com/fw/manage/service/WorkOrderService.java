package com.fw.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fw.manage.entity.WorkOrder;
import com.fw.manage.web.domain.HttpResult;
import java.util.List;

/**
 * <p>
 * 测试表 服务类
 * </p>
 *
 * @author MP-ML
 * @since 2019-03-27
 */
public interface WorkOrderService extends IService<WorkOrder> {

    List<WorkOrder> list(Integer pageSize, Integer currentPageNo);

    HttpResult<Long> add(WorkOrder workOrder);

    HttpResult commit(Long id);

    HttpResult reserve(Long id);

    HttpResult<WorkOrder> detail(Long id);

    int count();

    List<WorkOrder> commitList(Integer pageSize, Integer currentPageNo);
}
