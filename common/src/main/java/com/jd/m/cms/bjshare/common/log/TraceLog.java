package com.jd.m.cms.bjshare.common.log;

import com.jd.m.njf.server.client.dto.NjfContext;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * 流水日志 增强log4j日志打印： 1、支持线程日志统一流水号； 2、简化去除log4j日志打印前的isXXX判断; 3、增加方法耗时监控日志打印
 * 
 * 
 * @author njzhufeifei
 */
public class TraceLog {

	private static final long serialVersionUID = 1L;

	private static final String MSG_SPLITTING = "|";
	
	private static final String BEGIN_INVOKE_METHODS = "beginInvokeMethods";

    /** 调用时间阈值, 默认1秒 */
    private static long         DEFAULT_THRESHOLD = 1000L;

	/** logger */
	protected Log log;

    public TraceLog(Log log) {
		this.log = log;
	}

	public void trace(Object message) {
		if (log.isTraceEnabled()) {
			log.trace(createTraceMsg(message));
		}
	}

	public void trace(Object message, Throwable t) {
		if (log.isTraceEnabled()) {
			log.trace(createTraceMsg(message), t);
		}
	}

	public void debug(Object message) {
		if (log.isDebugEnabled()) {
			log.debug(createTraceMsg(message));
		}
	}

	public void debug(Object message, Throwable t) {
		if (log.isDebugEnabled()) {
			log.debug(createTraceMsg(message), t);
		}
	}

	public void info(Object message) {
		if (log.isInfoEnabled()) {
			log.info(createTraceMsg(message));
		}
	}

	public void info(Object message, Throwable t) {
		if (log.isInfoEnabled()) {
			log.info(createTraceMsg(message), t);
		}
	}

	public void warn(Object message) {
		if (log.isWarnEnabled()) {
			log.warn(createTraceMsg(message));
		}
	}

	public void warn(Object message, Throwable t) {
		if (log.isWarnEnabled()) {
			log.warn(createTraceMsg(message), t);
		}
	}

	public void error(Object message) {
		if (log.isErrorEnabled()) {
			log.error(createTraceMsg(message));
		}
	}

	public void error(Object message, Throwable t) {
		if (log.isErrorEnabled()) {
			log.error(createTraceMsg(message), t);
		}
	}

	public void fatal(Object message) {
		if (log.isFatalEnabled()) {
			log.fatal(createTraceMsg(message));
		}
	}

	public void fatal(Object message, Throwable t) {
		if (log.isFatalEnabled()) {
			log.fatal(createTraceMsg(message), t);
		}
	}

	/**
	 * 调用方法耗时监控开始
	 * 
	 * @param methodName
	 *            方法名，需要和invokeEnd方法传值相同
	 */
	@SuppressWarnings("unchecked")
	public void invokeBegin(String methodName) {
		if (StringUtils.isBlank(methodName)) {
			this.error("invokeBegin error for methodName is null!");
			return;
		}
		Map<String, Long> invokeMethods = (Map<String, Long>) TraceLogFactory.getValue(BEGIN_INVOKE_METHODS);
		if (invokeMethods == null) {
			invokeMethods = new HashMap<String, Long>();
			TraceLogFactory.addMdcKV(BEGIN_INVOKE_METHODS, invokeMethods);
		}
		invokeMethods.put(methodName, System.currentTimeMillis());
	}

    /**
     * 调用方法耗时监控结束
     * @param methodName
     */
    public void invokeEnd(String methodName) {
        invokeEnd(methodName, null);
    }

    /**
     * 调用方法耗时监控结束
     * 
     * @param methodName 方法名，需要和invokeBegin方法传值相同
     */
    @SuppressWarnings("unchecked")
	public void invokeEnd(String methodName, Long threshold) {
        if (threshold == null) {
            threshold = DEFAULT_THRESHOLD;
	    }
        Map<String, Long> invokeMethods = (Map<String, Long>) TraceLogFactory.getValue(BEGIN_INVOKE_METHODS);
		if (invokeMethods == null || invokeMethods.get(methodName) == null) {
			this.error("invokeEnd error for methodName is not invokeBegin!");
			return;
		}
		long beginTime = (Long)invokeMethods.get(methodName);
		long usedTime = System.currentTimeMillis() - beginTime;
		if (usedTime > threshold) {
			this.warn("invoking method " + methodName + " used:" + usedTime
					+ " ms!");
		} else {
			this.info("invoking method " + methodName + " used:" + usedTime
					+ " ms!");
		}
		invokeMethods.remove(methodName);
	}

	private String createTraceMsg(Object message) {
		StringBuilder sb = new StringBuilder();
		String msg = String.valueOf(message);
		sb.append(TraceLogFactory.getAndAddLogSN()).append(MSG_SPLITTING)
		.append(TraceLogFactory.getInvokeNo()).append(MSG_SPLITTING)
		.append(Thread.currentThread().getId()).append(MSG_SPLITTING)
		.append(TraceLogFactory.getInvokeIp()).append(MSG_SPLITTING);
		
		if(NjfContext.getContext() != null){
			sb.append(NjfContext.getContext().getId()).append(MSG_SPLITTING);
		} else {
			sb.append("rpcContextEmpty").append(MSG_SPLITTING);
		}
		
		sb.append(msg);
		return sb.toString();
	}
}
