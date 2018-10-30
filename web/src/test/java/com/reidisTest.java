package com;

import com.jd.bjshare.domain.StaticalBean;
import com.jd.jim.cli.driver.types.ScanOptions;
import com.jd.m.cms.bjshare.common.utils.JsonUtil;
import com.jd.m.statistics.common.utils.DateUtil;
import com.jd.m.statistics.domain.enums.RedisKeyEnum;
import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LPC on 2018/8/22
 */
public class reidisTest {

    @Test
    public void testsetJedis() throws Exception {
        // 第一步：创建一个Jedis对象。需要指定服务端的ip及端口。
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 第二步：使用Jedis对象操作数据库，每个redis命令对应一个方法。
        jedis.set("helloqq", "helloqq");
        jedis.close();
    }

    @Test
    public void testgetJedis() throws Exception {
        // 第一步：创建一个Jedis对象。需要指定服务端的ip及端口。
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 第二步：使用Jedis对象操作数据库，每个redis命令对应一个方法。
        String result = jedis.get("hello");
        // 第三步：打印结果。
        System.out.println(result);
        // 第四步：关闭Jedis
        jedis.close();
    }

    @Test
    public void testHScan() {
        // 第一步：创建一个Jedis对象。需要指定服务端的ip及端口。
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //HSCAN 命令用于迭代哈希键中的键值对。
        Map<String, String> data = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            data.put("key" + i, String.valueOf(i));
        }
        //获取到key===share_client_uv:20180826
        String redisKey1 = RedisKeyEnum.SHARE_CLIENT_UV.getCacheKey(DateUtil.formatDateToString(DateUtil.datePlusDays(new Date(), -1), DateUtil.YYMMDD_STR));
        jedis.hmset(redisKey1, data);
        ScanResult<Map.Entry<String, String>> result;// =  jedis.hscan("hash",DATASOURCE_SELECT);
        int count = 0;
        int cursor = 0;
        ScanParams scanParams = new ScanParams();
        // 设置每次scan个数
        scanParams.count(15);
        while (true) {
            result = jedis.hscan("hash", cursor, scanParams);
            // 获取新的游标
            cursor = Integer.valueOf(result.getStringCursor());
            System.out.println("cursor============" + cursor);
            for (Map.Entry<String, String> map : result.getResult()) {
                System.out.println(map.getKey() + ":" + map.getValue());
                count++;
            }
            // 如果游标是0表示遍历结束
            if (cursor == 0) {
                System.out.println("count=======" + count);
                break;
            }
        }
    }

    @Test
    public  void insertHash(){
        // 第一步：创建一个Jedis对象。需要指定服务端的ip及端口。
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String redisKey = RedisKeyEnum.SHARE_CLIENT_UV.getCacheKey(DateUtil.formatDateToString(new Date(), DateUtil.YYMMDD_STR));
        for(int i=1;i<101;i++){
            StaticalBean staticalBean=new StaticalBean();
            staticalBean = new StaticalBean();
            staticalBean.setActivityId(111111L);
            staticalBean.setActivityName("活动名称");
            staticalBean.setBizId(i+"");
            staticalBean.setBizType(1);
            staticalBean.setCount(1l);
            staticalBean.setVenderId(999999L);
            String key = "1_" + i;
            jedis.hset(redisKey,key, JsonUtil.write2JsonStr(staticalBean));
        }
    }

    @Test
    public  void getHash() {

        // 第一步：创建一个Jedis对象。需要指定服务端的ip及端口。
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String redisKey = RedisKeyEnum.SHARE_CLIENT_UV.getCacheKey(DateUtil.formatDateToString(new Date(), DateUtil.YYMMDD_STR));
        // 游标
        int count = 0;
        int cursor = 0;
        ScanResult<Map.Entry<String, String>> result;
        ScanParams scanParams = new ScanParams();
        // 设置每次scan个数
        scanParams.count(15);
        while (true) {
            result = jedis.hscan(redisKey, cursor, scanParams);
            // 获取新的游标
            cursor = Integer.valueOf(result.getStringCursor());
            System.out.println("cursor============" + cursor);
            List<Map.Entry<String, String>> elements = result.getResult();
            if (elements != null && elements.size() > 0) {
                for (Map.Entry<String, String> element : elements) {
                    StaticalBean staticalBean = (StaticalBean) JsonUtil.json2Object(element.getValue(), StaticalBean.class);
                    System.out.println("staticalBean==========key:" + JsonUtil.write2JsonStr(element.getKey()));
                    System.out.println("staticalBean==========value:" + JsonUtil.write2JsonStr(staticalBean));
                }
            }
            if(cursor==0){
                System.out.println("获取值结束方法===============");
                break;
            }
        }
    }

}
