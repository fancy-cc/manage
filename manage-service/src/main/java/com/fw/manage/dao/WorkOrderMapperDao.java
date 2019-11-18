package com.fw.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fw.manage.entity.WorkOrder;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 测试表 Mapper 接口
 * </p>
 *
 * @author MP-ML
 * @since 2019-03-27
 */
public interface WorkOrderMapperDao extends BaseMapper<WorkOrder> {

    List<WorkOrder> selectByPage(@Param(value = "start") Integer start, @Param(value = "pageSize") Integer pageSize);

    int selectByPageCount();

    List<WorkOrder> selectCommitListByPage(@Param(value = "start") Integer start, @Param(value = "pageSize") Integer pageSize);
}
