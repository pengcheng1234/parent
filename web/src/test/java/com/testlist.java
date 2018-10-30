package com;

import com.jd.m.cms.bjshare.common.utils.JsonUtil;
import com.jd.m.cms.bjshare.domain.po.Role;
import com.jd.m.cms.bjshare.domain.vo.ActivityDataStatisticalExtend;
import com.jd.m.cms.bjshare.domain.vo.UvData;
import org.junit.Test;

import java.util.*;

/**
 * Created by LPC on 2018/9/30
 */
public class testlist {

    @Test
    public void  tset(){
        List<String> aa =new ArrayList<String>();
        List<String> aaa =new ArrayList<String>();
        aa.add("woshi");
        aa.add("tashi");
        aa.add("sanshi");
        Boolean flag=aaa.contains("tashi");
        Boolean flag1=aaa.contains("asdfa");
        System.out.println("flag="+flag);
        System.out.println("flag1="+flag1);

        Map<String,Object> map=new HashMap<String,Object>();

        if(map.get("adfaf")==null){

            System.out.println("kong");

        }
        for(int i=0;i<100;i++){
            System.out.println( (long)new Random().nextInt(200));

        }
     }


    public void getUV(List<UvData> list){
                for(int i=0;i<list.size();i++){
                    list.get(i).setActivityId(0l);
                }
    }
    @Test
    public void  tset2(){
        List<UvData> list=new ArrayList<UvData>();
        for(int i=0;i<100;i++){
            UvData dto=new UvData();
            dto.setActivityId((long)i);
            dto.setUvNum((long)new Random().nextInt(200));
            list.add(dto);
        }
        for(int i=0;i<100;i++){
            System.out.println(i+";"+list.get(i).getActivityId());
        }
        List<UvData> list2=new ArrayList<UvData>();
        list2.addAll(list);
        for(int i=0;i<100;i++){
            System.out.println(i+"ttttttttttttt;"+list2.get(i).getActivityId());
        }
        List<UvData> list3=new ArrayList<UvData>();
        list3.addAll(list);
        for(int i=0;i<100;i++){
            System.out.println(i+"ttttttttttttt;"+list3.get(i).getActivityId());
        }

        list2.addAll(list3);
        for(int i=0;i<100;i++){
            System.out.println(i+"aaaa;"+list2.get(i).getActivityId());
        }

    }

    @Test
    public void  StringBulider(){
        StringBuilder message =new StringBuilder();
        System.out.println(message.length());
        message.append("asdf");
        System.out.println(message.length());

    }

    @Test
    public void  tset3(){
        UvData dto=new UvData();
        ActivityDataStatisticalExtend end =new ActivityDataStatisticalExtend();
        end.setShareSuccessUv(9L);
        end.setShareSuccessUv(dto.getUvNum());
        System.out.println(JsonUtil.write2JsonStr(end));

    }

    @Test
    public void  listToString(){
        Set<String> list=new HashSet<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        Set<String> list2=new HashSet<String>();
        list2.add("1");
        list2.add("2");
        list.removeAll(list2);
        System.out.println(list.toString()+"");

    }
    @Test
    public void  listaddList(){
        List<String> list=new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        List<String> list2=null;
        list.addAll(list2);
        System.out.println(list.toString()+"");

    }

    @Test
    public void  setRemove(){
        Set<Role> list=new HashSet<Role>();
        for(int i=1;i<4;i++){
            Role dto=new Role();
            dto.setUserErp("erp"+i+"");
            dto.setUserName("name"+i);
            dto.setDeptName("dept"+i);
            list.add(dto);
        }
        System.out.println(list.toString()+"");
        Role dto=new Role();
        dto.setUserErp("erp2");
        dto.setUserName("name2");
        list.remove(dto);
        System.out.println(list.toString()+"");
    }

    @Test
    public void  listItegeator(){
        Set<Role> list=new HashSet<Role>();
        for(int i=1;i<4;i++){
            Role dto=new Role();
            dto.setUserErp("erp"+i+"");
            dto.setUserName("name"+i);
            dto.setDeptName("dept"+i);
            list.add(dto);
        }
        Iterator<Role> it=list.iterator();
        while(it.hasNext()){
            Role dto1=it.next();
            System.out.println(dto1.getUserErp());
            if("erp1".equals(dto1.getUserErp())){
                it.remove();
            }
        }
        System.out.println("99999999999999999999");
        for(Role dto:list){
            System.out.println(dto.getUserErp());
        }
        System.out.println(list.toString()+"");
    }

    @Test
    public void  listFor(){
        List<Role> list=new ArrayList<Role>();
        for(Role dto:list){
            System.out.println(dto.getUserErp());

        }
    }

    @Test
    public void  StringToArray(){
        String aa="asdf";
        String bb[]=aa.split(";");
        System.out.println(bb.toString());
    }

    @Test
    public void  objecttobyte(){
        Map<String,Object> map=new HashMap<String,Object>();
        Integer a=2;
        map.put("a",a);

        int b=(Integer)map.get("a");
        System.out.println(map.get("a")==2);
        Byte type=(byte)b;
        System.out.println(type.toString());
    }

    @Test
    public void  listAdd(){
        List<Integer> list=new ArrayList<Integer>();
        List<Integer> list1=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.addAll(list);


//        list1.addAll(list);
        System.out.println(list1.toString());
    }

    @Test
    public void  DateDiff(){
        Date date1=new Date();
        Date date2=new Date();


        System.out.println(date1.after(date2));
    }

    @Test
    public void  tolist(){
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        list1.add("1");
        list2=list1;
        list2.add("2");


        System.out.println(new Random().nextInt(100));
        System.out.println(list2.toString());
    }

    @Test
    public void  tojian(){
        Integer a=333333;


        System.out.println(a.byteValue());
    }

    @Test
    public void  toswitch(){
        int  a=44;
        switch (a){
            case 0: System.out.println(0);
            case 1: System.out.println(1);
            case 2: System.out.println(2);
            case 3: System.out.println(3);break;
            case 4: System.out.println(4);
            default:System.out.println("default");
        }


    }

}
