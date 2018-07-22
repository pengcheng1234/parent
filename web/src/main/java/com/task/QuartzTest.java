package com.task;

import java.util.Date;

/**
 * Created by LPC on 2018/7/20
 */
public class QuartzTest {
    //到了某个时刻就会被调用
    public void autoRun(){
        System.out.println("It's time to run :" + new Date().toString());
        //TODO 执行任务逻辑
        //........
    }
}
