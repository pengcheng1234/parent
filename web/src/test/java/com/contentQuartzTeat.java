package com;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
/**
 * Created by LPC on 2018/7/20
 */

public class contentQuartzTeat {
    //本地测试，不用部署到tomcat
    @Test
    public  void run() {
        System.out.println("测试任务调度开始...");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-quartz.xml");
        // 如果配置文件中将startQuertz bean的lazy-init设置为false 则不用实例化
        // context.getBean("startQuertz");
        System.out.print("测试任务调度结束!\n");
    }
}
