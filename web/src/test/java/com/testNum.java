package com;

import com.jd.bjshare.domain.test;
import com.jd.m.statistics.domain.Statistical;
import com.jd.m.statistics.domain.StatisticalKey;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import com.jd.m.cms.bjshare.web.util.RoleUtil;
import java.util.Map;

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

    @Test
    public  void RoleUtil(){

        System.out.println(RoleUtil.hasState(RoleUtil.ROLE_SALER,4));
        System.out.println(RoleUtil.ROLE_SALER);
    }

    @Test
    public  void BigDecimal(){
        BigDecimal big=new BigDecimal(94.7);
        System.out.println(big.toString());
    }




    @Test
    public  void testMap(){

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("aa","aa");
        Boolean aaflag=map.containsKey("aa");
//        System.out.println(aaflag);
        Boolean bbflag=map.containsKey("bb");
//        System.out.println(bbflag);

        String c="1234@5678";
        String d=c.substring(0,c.indexOf("@"));
        String e=c.substring(c.indexOf("@")+1,c.length());
//        System.out.println(d);
//        System.out.println(e);
        Map<test,Object> map1=new HashMap<test,Object>();
        test t1=new test("1","1");
        map1.put(t1,"11");

        test t2=new test("1","1");
        System.out.println(map1.get(t2));


    }

    @Test
    public  void testMapKey(){

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("aa","aa");
        Boolean aaflag=map.containsKey("aa");
        System.out.println(aaflag);
        map.get("bb");
        Boolean bbflag=map.containsKey("bb");
        System.out.println(bbflag);
        Map<StatisticalKey, Statistical> statisticalCollection=new HashMap<StatisticalKey, Statistical>();
        StatisticalKey key1=new StatisticalKey(11,"11");
        Statistical cal1=new Statistical();
        Statistical statistical=statisticalCollection.get(key1);
        System.out.println(statistical);
    }

    @Test
    public  void testreplace(){
        String aaa="asdf";
        aaa.replace(",","!");
        System.out.println(aaa);
        aaa=aaa.replace(",","@");
        System.out.println(aaa);
        String erpList[]=aaa.split(",");
        System.out.println(erpList.length);

    }


}
