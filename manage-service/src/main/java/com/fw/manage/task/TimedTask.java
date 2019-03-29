package com.fw.manage.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class TimedTask {

    @Value("hello")
    private String hello;

    @Value("world")
    private String world;

//    @Scheduled(cron = "0 */1 * * * ?")
    public void execute() {
        System.out.println(hello + " : Pock Face");
        System.out.println(world + " : charming T");
    }
}
