package com.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 强 on 2018/12/10.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");
        Performer performer = (Performer) ctx.getBean("hank");
        performer.perform();
    }
}
