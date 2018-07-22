package com;

import org.junit.Test;

/**
 * Created by LPC on 2018/7/16
 */
public class testNum {


    @Test
    public  void getNum(){
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<202;i++){
            buffer.append(",202"+String.valueOf(i));
        }
        System.out.println(buffer);
    }
}
