package com.fw.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fw.manage.dao.WorkOrderMapperDao;
import com.fw.manage.entity.WorkOrder;
import com.fw.manage.service.WorkOrderService;
import com.fw.manage.web.domain.HttpResult;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author MP-ML
 * @since 2019-03-27
 */
@Service
public class WorkOrderServiceImpl extends ServiceImpl<WorkOrderMapperDao, WorkOrder> implements WorkOrderService {

    @Resource
    private WorkOrderMapperDao workOrderMapperDao;

    @Override
    public HttpResult<Long> add(WorkOrder workOrder) {
        int insertCount = workOrderMapperDao.insert(workOrder);
        if (insertCount == 1) {
            return HttpResult.success(workOrder.getId());
        }
        return HttpResult.failure("提交订单失败");
    }

    @Override
    public List<WorkOrder> list(Integer pageSize, Integer currentPageNo) {
        int start = (currentPageNo - 1) * pageSize;
        List<WorkOrder> list = workOrderMapperDao.selectByPage(start,pageSize);
        return (list == null || list.isEmpty()) ? new ArrayList<>() : list;
    }

    @Override
    public HttpResult commit(Long id) {
        int updateCount = workOrderMapperDao.update(
                new WorkOrder(), new UpdateWrapper<WorkOrder>().lambda().set(WorkOrder::getStatus, 3).eq(WorkOrder::getId, id)
        );
        if (updateCount == 1) {
            return HttpResult.success("操作成功，订单已完结");
        }
        return HttpResult.failure("操作失败，请重新确认订单完结");
    }

    @Override
    public HttpResult reserve(Long id) {
        int updateCount = workOrderMapperDao.update(
                new WorkOrder(), new UpdateWrapper<WorkOrder>().lambda().set(WorkOrder::getStatus, 1).eq(WorkOrder::getId, id)
        );
        if (updateCount == 1) {
            return HttpResult.success("成功预约");
        }
        return HttpResult.failure("操作失败，请重新确认");
    }

    @Override
    public HttpResult<WorkOrder> detail(Long id) {
        WorkOrder workOrder = workOrderMapperDao.selectById(id);
        if (workOrder == null) {
            return HttpResult.failure("查询失败，请重试");
        }
        return HttpResult.success(workOrder);
    }

    @Override
    public int count() {
        int count = workOrderMapperDao.selectByPageCount();
        return count;
    }

    @Override
    public List<WorkOrder> commitList(Integer pageSize, Integer currentPageNo) {
        int start = (currentPageNo - 1) * pageSize;
        List<WorkOrder> list = workOrderMapperDao.selectCommitListByPage(start, pageSize);
        return (list == null || list.isEmpty()) ? new ArrayList<>() : list;
    }
}
