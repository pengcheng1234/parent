package com.jd.m.cms.bjshare.web.quartz;

import com.redis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LPC on 2018/7/19
 */
@Component
public class quartzTest2 {

    @Autowired
    private JedisClient jedisClient;

    // 每1秒执行一次
//    @Scheduled(cron = "0/1 * * * * ?")
    public void  TaskJob() {

        Date date=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String  time=formatter.format(date);
        System.out.println("time22=======."+time);

//        boolean flag1=jedisClient.tryGetDistributedLock("lock","time22",8000);
//        if(flag1){
//            System.out.println("time22得到锁");
//
//            boolean flag2=jedisClient.releaseDistributedLock("lock","time22");
//            if(flag2){
//                System.out.println("time22释放锁");
//            }
//        }
    }
}
