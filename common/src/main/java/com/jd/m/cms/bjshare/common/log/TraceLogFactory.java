package com.jd.m.cms.bjshare.common.log;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * TraceLog工厂
 * 使用方法和log4j的LogFactory几乎相同
 * 
 * 使用TraceLog需要在请求发起的时候调用TraceLogFactory.initTracer()来清除上次请求的流水号
 *  
 * @author njzhufeifei
 */
public class TraceLogFactory {

	private static final TraceLog traceLog = TraceLogFactory.getTraceLog(TraceLogFactory.class);
	
	public static final String INVOKE_NO_KEY = "invokeNo"; // 日志唯一标识
	
	public static final String INVOKE_IP_KEY = "invokeIp"; // 请求ip
	
	public static final String INVOKE_SN_KEY = "invokeSerialNum"; // 日志序列号key
	
	private static ThreadLocal<Map<String, Object>> mdc = new ThreadLocal<Map<String, Object>>();
	
	public static Map<String, Object> getMDC(){
		if (mdc.get() == null) {
			mdc.set(new HashMap<String, Object>());
        }
		return mdc.get();
	}
	
	public static Object getValue(String key){
		if(StringUtils.isNotBlank(key)){
			return getMDC().get(key);
		}
		return null;
	}
	
	public static void removeValue(String key){
		if(StringUtils.isNotBlank(key)){
			getMDC().remove(key);
		}
	}
	
	public static void addMdcKV(String key, Object value){
		if(StringUtils.isNotBlank(key)){
			getMDC().put(key, value);
		}
	}
	
	public static void addMdcMap(Map<String, Object> mdcMap){
		if(!CollectionUtils.isEmpty(mdcMap)){
			getMDC().putAll(mdcMap);
		}
	}
	
	private static void clear(){
		getMDC().clear();
	}
	
	private static void setInvokeIp(String invokeIp){
		getMDC().put(INVOKE_IP_KEY, invokeIp);
	}
	
	public static void initTracer(String invokeIp){
		clear();
		setInvokeIp(invokeIp);
	}
	
	public static String getInvokeIp(){
		return String.valueOf(getMDC().get(INVOKE_IP_KEY));
	}
	
	public static String getInvokeNo(){
		if(getMDC().get(INVOKE_NO_KEY) == null){
			getMDC().put(INVOKE_NO_KEY, UUID.randomUUID().toString().replace("-", ""));
		}
		return String.valueOf(getMDC().get(INVOKE_NO_KEY));
	}
	
	public static int getAndAddLogSN(){
	    int serialNumber = 0;
        if(getMDC().get(INVOKE_SN_KEY) != null){
            serialNumber = (Integer)getMDC().get(INVOKE_SN_KEY);
        }
        getMDC().put(INVOKE_SN_KEY, ++serialNumber);
        return serialNumber;
    }
	
	/**
	 * 获取TraceLog对象，支持方法执行时间阈值指定
	 * @param clazz
	 * @return
	 */
    public static TraceLog getTraceLog(Class<?> clazz) {
        return new TraceLog(LogFactory.getLog(clazz));
	}
    
    /**
	 * 获取TraceLog对象，支持方法执行时间阈值指定
	 * @param loggerName loggerName
	 * @return
	 */
    public static TraceLog getTraceLog(String loggerName) {
        return new TraceLog(LogFactory.getLog(loggerName));
	}

    /**
     * 同步父线程的mdcMap到子线程
     * 
     * @param parentThread
     * @param parentMdcMap
     */
    public static void putMdcMap(Thread parentThread, Map<String, Object> parentMdcMap){
		/** 
		 * 当前线程号不等于主线程线程号的时候才需要传递mdc;
		 * 因为线程池的拒绝策略是超出容量的就直接主线程调用，所以这个run方法不一定事新的线程调用
		 */
		if(Thread.currentThread().getId() != parentThread.getId()){
			TraceLogFactory.putMdcMap(parentMdcMap);
		}
		
		// parent thread mdcMap，这个日志用于tracelog流水号问题检查
		traceLog.debug("mdcMap-parent" + parentMdcMap.toString());
		traceLog.debug("mdcMap-child: " + TraceLogFactory.getMDC().toString());
    }
    
	private static void putMdcMap(Map<String, Object> mdcMap){
		getMDC().clear();
		if(!CollectionUtils.isEmpty(mdcMap)){
			getMDC().putAll(mdcMap);
		}
	}
    
}
