package com.jd.m.cms.bjshare.web.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LPC on 2018/7/19
 */
@Component
public class quartzTest {

    // 每五秒执行一次
//    @Scheduled(cron = "0/5 * * * * ?")
    public void TaskJob() {
        Date date=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String  time=formatter.format(date);
        System.out.println("time=======."+time);
    }
}
