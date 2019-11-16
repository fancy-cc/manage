package com.fw.manage.service;

import com.fw.manage.entity.WorkOrder;
import com.fw.manage.web.domain.HttpResult;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ZhongWeiTests {

    @Resource
    private WorkOrderService workOrderService;

    @Test
    public void contextLoads() {
        System.out.println("Hello World");
    }

    @Test
    public void getOrder() {
        List<WorkOrder> list = workOrderService.list(2,1);
        System.out.println("hello::" + list);
    }

  /*  @Test
    public void addTest() {
        WorkOrder workOrder = new WorkOrder();
        workOrder.setAddress("wodi");
        workOrder.setMessage("helwo");
        workOrder.setMobile("12343232");
        workOrder.setType(1);
        workOrder.setServiceTime(LocalDateTime.now());
        HttpResult httpResult = workOrderService.add(workOrder);
        System.out.println("heloo::" + httpResult);
    }*/

/*    @Test
    public void allTest() {
        HttpResult httpResult = workOrderService.commit(1L);
        System.out.println("@@@@@111::" + httpResult.getEntry());

        HttpResult httpResult1 = workOrderService.reserve(2L);
        System.out.println("@@@@@222::" + httpResult1.getEntry());

        HttpResult httpResult2 = workOrderService.detail(3L);
        System.out.println("@@@@333::" + httpResult2.getEntry());
    }*/

  /*  @Test
    public void countTest() {
        int count = workOrderService.count();
        System.out.println("#####:::" + count);
    }*/
}
