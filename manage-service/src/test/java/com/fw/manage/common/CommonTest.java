package com.fw.manage.common;

import java.util.concurrent.CountDownLatch;

public class CommonTest {
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public static void main(String[] args) {
        int threads = 9;

        CommonTest commonTest = new CommonTest();
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(() ->{
                commonTest.setString(Thread.currentThread().getName());
                System.out.println(commonTest.getString());
                countDownLatch.countDown();
            }, "thread - " + i);
            thread.start();
        }
    }
}
