package com.test;

import com.jd.m.cms.bjshare.common.utils.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LPC on 2018/9/14
 */
public class list {

    @Test
    public void test1(){
        List<String> list=new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        for(int i=0;i<list.size();i++){
//            list.add("1"+i);
        }
        System.out.println();

    }

}
