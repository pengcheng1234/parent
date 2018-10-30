package com.test;

import com.jd.m.cms.bjshare.domain.bean.SkuValidateResult;
import com.jd.m.njf.server.client.util.JsonUtil;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author huanglong
 * @Description: sku的校验
 * @date 2018/7/418:42
 */
public class ValidateServiceImpl {



    private static ThreadPoolExecutor executor1 = new ThreadPoolExecutor(5, 30, 300, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

    private static ThreadPoolExecutor executor2 = new ThreadPoolExecutor(10, 100, 300, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

    /* 每个线程验证90个sku */
    private static final Integer num = 90;

    @Test
    public void validateSkuService() {

         List<Long> validateListt = new ArrayList<Long>();
        final List<Long> validateList ;
        for (int i = 0; i < 300; i++) {
            validateListt.add(Long.valueOf(i));
        }
        validateList=validateListt;
        executor2.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("9999999999999999");
                List<Future<SkuValidateResult>> list = new ArrayList<Future<SkuValidateResult>>();
                int count = (validateList.size() - 1) / num + 1;
                for (int i = 0; i < count; i++) {
                    List<Long> li = (i == (count - 1)) ? validateList.subList(i * num, validateList.size()) : validateList.subList(i * num, (i + 1) * num);
                    Future<SkuValidateResult> future = executor1.submit(new ValidateSku(li, i, i));
                    System.out.println("任务加...入线程池\" + i + \":处理数量：" + li.size());
                    list.add(future);
                }

                for (Future f : list) {
                    SkuValidateResult re = null;
                    try {
                        re = (SkuValidateResult) f.get();
                        System.out.println(JsonUtil.write2JsonStr(re));
                    } catch (Exception e) {
                        System.out.println("出错了");
                    }
                }
            }
        });
        try{
            Thread.sleep(2000);
        }catch (Exception E){

        }

    }

    @Test
    public void shuzu(){
        String code="23,34,45";
        String[] item=code.split(",");
        System.out.println(item[0]);
        System.out.println(item[1]);
        System.out.println(item[2]);
    }
}



class ValidateSku implements Callable<SkuValidateResult> {

    private List<Long> data;

    private int saler;

    private Integer level;

    public ValidateSku(List<Long> data, int saler, int level) {
        this.data = data;
        this.saler = saler;
        this.level = level;
    }

    @Override
    public SkuValidateResult call() {
        SkuValidateResult skuValidateResult = new SkuValidateResult();
        Set<Long> arg0 = skuValidateResult.getValidatSkus();
        Set<Long> arg1 = skuValidateResult.getSkusTpyeError();
        Set<Long> arg2 = skuValidateResult.getSkusInActivity();
        Set<Long> arg3 = skuValidateResult.getSkusNotSelf();
            /* 是否是自营 */
        if (data != null && data.size() > 0) {
            switch (saler){
                case 0:
                    for(Long arg :data){
                        arg0.add(arg);
                    }
                    break;
                case 1:
                    for(Long arg :data){
                        arg1.add(arg);
                    }
                    break;
                case 2:
                    for(Long arg :data){
                        arg2.add(arg);
                    }
                    break;
                case 3:
                    for(Long arg :data){
                        arg3.add(arg);
                    }
                    break;
            }
        }
        return skuValidateResult;
    }
}


