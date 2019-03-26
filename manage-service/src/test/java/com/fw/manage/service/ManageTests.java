package com.fw.manage.service;

import com.fw.manage.entity.User;
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
    private UserService userService;

    @Test
    public void contextLoads() {
        System.out.println("Hello World");
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
    public void druidTest() throws Exception{
        try {
            System.out.println("hello: " + this.dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void userTest() {
        User user = new User();
        user.setName("夏天").setType(0);
        userService.insert(user);
        System.out.println("user add test: " + user.getId());
    }

    @Test
    public void userSelectTest() {
        User user = userService.select(4L);
        System.out.println("User: " + user.toString());
    }

    @Test
    public void arraysSortTest() {
        int[] a = {2, 4, 56, 6, 9, 30};
        Arrays.sort(a);
        System.out.println("a: " + Arrays.toString(a));

        int[][] b = {{2, 4, 6, 8}, {1, 3, 5 ,7}, {11, 22, 33, 44, 55}};
        System.out.println("b: " + Arrays.deepToString(b));
    }

}
