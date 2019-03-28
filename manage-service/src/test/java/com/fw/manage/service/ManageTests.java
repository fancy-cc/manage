package com.fw.manage.service;

import com.alibaba.fastjson.JSON;
import com.fw.manage.entity.Customer;
import com.fw.manage.web.domain.HttpResult;
import com.fw.manage.web.domain.PageResultSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ManageTests {

    @Resource
    private DataSource dataSource;

    @Resource
    private CustomerService customerService;

    @Test
    public void contextLoads() {
        System.out.println("Hello World");
    }


    @Test
    public void addCustomerTest() {
        Customer customer = new Customer();
        customer.setName("清风徐来");
        customer.setType(1);
        HttpResult httpResult = customerService.insertSelective(customer);
        System.out.println("httpResult  entry:" + httpResult.getEntry() + "; code:" + httpResult.getCode()
                + "; mes:" + httpResult.getMessage() + "; status:" + httpResult.getStatus());
    }

    @Test
    public void listTest() {
//        List<com.fw.manage.entity.Test> list = testService.list();
        List<Customer> list = customerService.list();
        PageResultSet pageResultSet = new PageResultSet();
        pageResultSet.setList(list);
        pageResultSet.setAllRow(list.size());
        HttpResult httpResult = HttpResult.success(pageResultSet);
        System.out.println("httpResult  entry:" + JSON.toJSONString(httpResult.getEntry()) + "; code:" + httpResult.getCode()
                + "; mes:" + httpResult.getMessage() + "; status:" + httpResult.getStatus());
    }

    @Test
    public void codePointsTest() {
        String str = "Hello";
        int[] codePoints = str.codePoints().toArray();
        for (int i : codePoints) {
            System.out.print("@@@: " + i + "、 ");
        }
        String string = new String(codePoints, 0, codePoints.length);
        System.out.println("new String:" + string);

        String ss = "ell";
        int bili = str.indexOf(ss);
        System.out.println("bili:" + bili);
        int aili = str.indexOf(ss, 1);
        System.out.println("aili:" + aili);

        List<String> list = new ArrayList<>();
        list.add(ss);
        list.add(str);
        list.add(string);
        System.out.println("String.join:" + String.join("-", list));

        StringBuilder builder = new StringBuilder();
        builder.append("hello").append("world");
        System.out.println("StringBuilder.append:" + builder);
    }

    @Test
    public void conditionTest() {
        int i = 0;
        do {
            ++i;
            System.out.println("number: " + i);
        } while (i < 10);
    }

    @Test
    public void arrayTest() {
        int[] a = {2, 4, 6, 7, 8, 0};
        System.out.println("Hellos: " + Arrays.toString(a));
    }

    @Test
    public void localDateTest() {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate.getYear: " + localDate.getYear());
        LocalDate thoughDate = localDate.plusDays(1000);
        System.out.println("thoughDate :" + thoughDate.getYear());
    }

    @Test
    public void arraysAsListTest() {
        String[] a = {"hello", "world", "over"};
        List<String> s = Arrays.asList(a);
        System.out.println("##" + Arrays.asList(a));
        System.out.println("list: " + s);
        System.out.println("Collections.emptyList(): " + Collections.EMPTY_LIST);
        System.out.println("new ArrayList(): " + new ArrayList<>());
    }

    @Test
    public void druidTest() throws Exception {
        try {
            System.out.println("hello: " + this.dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void arraysSortTest() {
        int[] a = {2, 4, 56, 6, 9, 30};
        Arrays.sort(a);
        System.out.println("a: " + Arrays.toString(a));

        int[][] b = {{2, 4, 6, 8}, {1, 3, 5, 7}, {11, 22, 33, 44, 55}};
        System.out.println("b: " + Arrays.deepToString(b));
    }

    @Test
    public void userDirTest() {
        String path = System.getProperty("user.dir");
        System.out.println("user.dir: " + path);
    }

}
