package com.task;

import java.util.Date;

/**
 * Created by LPC on 2018/7/20
 */
public class QuartzJob {
    public void work()
    {
        System.out.println("QuartzJob is time to run :" + new Date().toString());
    }
}
