package com.jd.m.worker.bjshare.common.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.jd.common.util.StringUtils;

import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * json转换方面的工具类,全部为静态方法
 *
 * @author zhaoyunxiao
 */
public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        // 设置序列化配置，为null的属性不加入到json中
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false); // map对象序列化的时候忽略值为null的key
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE).
                setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    private JsonUtil() {

    }

    /**
     * 将对象转换成json字符串,如果转换失败则返回null
     *
     * @param o
     *         需要转换为json的对象
     * @return 转换后的json字符串
     */
    public static String write2JsonStr(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            System.out.println("write2JsonStr, JsonUtil exception");
        }
        return StringUtils.EMPTY;
    }

    /**
     * 将json转换为对象 如果对象模版为内部类会出现问题，所以不要使用内部类
     *
     * @param json
     *         要转换的json
     * @param clazz
     *         要映射的类型
     * @return 转换成的目标对象，如果转换失败返回null
     */
    public static Object json2Object(String json, Class<?> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            System.out.println("json2Object, JsonUtil exception, json is:" );
        }
        return null;
    }

    /**
     * 将json字符串转换为Map
     *
     * @param json
     *         需要转换为Map的json字符串 {}开头结尾的
     * @return 转换后的map 如果转换失败返回null
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> json2Map(String json) {
        try {
            if (StringUtils.isBlank(json)) {
                return new HashMap<String, Object>();
            }
            return mapper.readValue(json, Map.class);
        } catch (Exception e) {
            System.out.println("json2Map, JsonUtil exception, json is:" );
        }
        return new HashMap<String, Object>();
    }

    /**
     * 将json数组转换为List<Map<String,Object>> json数组格式[{},{}]
     *
     * @param jsonArray
     *         需要转换的json数组
     * @return 转换后的列表 如果转换失败返回null
     */
    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> jsonArray2List(String jsonArray) {
        try {
            return mapper.readValue(jsonArray, List.class);
        } catch (Exception e) {
            System.out.println("jsonArray2List, JsonUtil exception, json is:" + jsonArray);
        }
        return new ArrayList<Map<String, Object>>();
    }
    
    /**
     * json array 转换成list对象
     * @param json
     * @param tr new TypeReference<List<User>>() {}
     * @return
     */
    public static List<?> json2ArrayObject(String json, TypeReference<?> tr) {
        try {
            return mapper.readValue(json, tr);
        } catch (Exception e) {
            System.out.println("json2ArrayObject, JsonUtil exception, json is:" );
        }
        return null;
    }
    
    /**
     * <String, User>  这种类型的hashmap 转换
     * @param json
     * @param keyClazz
     * @param valueClazz
     * @return
     */
    public static Map<?, ?> json2MapObject(String json, Class<?> keyClazz, Class<?> valueClazz) {
        try {
        	JavaType javaType = mapper.getTypeFactory().constructParametricType(HashMap.class, keyClazz, valueClazz);
            return mapper.readValue(json, javaType);
        } catch (Exception e) {
            System.out.println("json2MapObject, JsonUtil exception, json is:" );
        }
        return null;
    }

    public static JsonNode json2Node(String json) {
        try {
            return mapper.readValue(json, JsonNode.class);
        } catch (Exception e) {
            System.out.println("json2Node, JsonUtil exception, json is:" );
        }

        return null;
    }

    public static void node2Writer(Writer writer, JsonNode node) {
        try {
            mapper.writeValue(writer, node);
        } catch (Exception e) {
            System.out.println("node2Writer, JsonUtil exception, json is:" + node);
        }
    }
    
	public static void main(String[] args) {
        String str="{\"adOwnerId\":\"z_0\",\"adTrafficType\":89,\"adownerType\":5,\"brandId\":9429,\"cancelStatus\":1,\"clearStatus\":1,\"commissionRate\":1.50,\"cookieCreateTime\":1525247214000,\"cptTime\":1525247262076,\"defineUrlId\":0,\"dividedId\":12753,\"ex3\":\"1000040122\",\"firstLevel\":1320,\"gysShopid\":\"\",\"id\":194840774583640064,\"levelRuleId\":0,\"modifyTime\":1525247262076,\"num\":3,\"orderEmt\":2,\"orderId\":73656292027,\"orderPayPrice\":119.70,\"orderState\":3,\"orderTime\":1525247246000,\"orderType\":0,\"pin\":\"oceanhu_picb\",\"platForm\":1,\"plusFlag\":2,\"popId\":0,\"popVenderid\":\"\",\"price\":39.90,\"promotionCont\":1,\"refStatus\":0,\"ruleId\":12753,\"ruleType\":1,\"secondLevel\":1584,\"skuId\":3303098,\"skuName\":\"金龙鱼 食用油 非转基因 压榨 一级 纯正玉米油4L\",\"supplierCode\":\"bjcpylsm\",\"thirdLevel\":2676,\"traceAdOwnerId\":\"z_0\",\"traceType\":3,\"unionId\":1000089893,\"unionTrafficType\":89,\"unionType\":0,\"userLevel\":\"2\",\"version\":1,\"ygCosFee\":1.80,\"ygCosPrice\":119.70,\"ygCptStatus\":102}";
		Map<String, String> map = new HashMap<String, String>();
		map.put("aaaa", null);
		map.put("bbbb", "bbbbbbb");
		//System.out.println(JsonUtil.write2JsonStr(map));
        try {
//            CPS cps=(CPS) JsonUtil.json2Object(str,CPS.class);
//            System.out.println(cps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
