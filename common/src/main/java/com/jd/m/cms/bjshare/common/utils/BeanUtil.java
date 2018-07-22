package com.jd.m.cms.bjshare.common.utils;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能概述：对象属性拷贝工具类
 * object2map
 * map2object
 * copy bean properties
 * 
 * @author njzhufeifei
 */
public final class BeanUtil {
	

	/**
	 * @param source
	 *            源对象
	 * @param target
	 *            目标对象
	 */
	public static void copyProperties(Object source, Object target, String... ignoreProperties) {
		if (ignoreProperties == null || ignoreProperties.length <= 0) {
			org.springframework.beans.BeanUtils.copyProperties(source, target);
			return;
		}
		copyProperties(source, target, true, ignoreProperties);
	}

	/**
	 * @param source
	 *            源对象
	 * @param target
	 *            目标对象
	 * @param isCopyNull
	 *            源对象中的null属性不会被拷贝到目标对象
	 * @param ignoreProperties
	 *            忽略的属性列表
	 */
	public static void copyProperties(Object source, Object target, Boolean isCopyNull, String... ignoreProperties) {
		if (isCopyNull) {
			org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
			return;
		}

		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");

		Class<?> actualEditable = target.getClass();
		PropertyDescriptor[] targetProperties = org.springframework.beans.BeanUtils.getPropertyDescriptors(actualEditable);
		List<String> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;

		for (PropertyDescriptor targetProperty : targetProperties) {
			if (targetProperty.getWriteMethod() == null) {
				continue;
			}

			if (ignoreProperties != null && (ignoreList.contains(targetProperty.getName()))) {
				continue;
			}

			PropertyDescriptor sourceProperty = org.springframework.beans.BeanUtils.getPropertyDescriptor(source.getClass(), targetProperty.getName());
			if (sourceProperty == null || sourceProperty.getReadMethod() == null) {
				continue;
			}

			try {
				Method readMethod = sourceProperty.getReadMethod();
				if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
					readMethod.setAccessible(true);
				}
				Object value = readMethod.invoke(source);
				if (value == null) {
					continue;
				}

				Method writeMethod = targetProperty.getWriteMethod();
				if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
					writeMethod.setAccessible(true);
				}
				writeMethod.invoke(target, value);
			} catch (Throwable ex) {
				throw new FatalBeanException("Could not copy properties from source to target", ex);
			}
		}
	}

	/**
	 * 取得指定对象的属性值
	 * 
	 * @param obj
	 * @param property
	 * @return
	 */
	public static Object getProperty(Object obj, String property) {
		Object value = null;
		try {
			value = PropertyUtils.getProperty(obj, property);
		} catch (Exception e) {
		}
		return value;
	}
	
	/** 
     * 将一个 JavaBean 对象转化为一个  Map 
     * @param bean 要转化的JavaBean 对象 
     * @return 转化出来的  Map 对象 
     */  
    public static Map<String, Object> bean2map(Object bean) {  
        Class<?> type = bean.getClass();  
        Map<String, Object> returnMap = new HashMap<String, Object>();  
        BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(type);
		} catch (IntrospectionException e) {
			return null;
		}  
  
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();  
        for (PropertyDescriptor descriptor : propertyDescriptors) {  
            String propertyName = descriptor.getName();  
            if (!propertyName.equals("class")) {  
                Method readMethod = descriptor.getReadMethod();  
                Object result = null;
				try {
					result = readMethod.invoke(bean, new Object[0]);
				} catch (Exception e) {
				}
                if (result != null) {  
                    returnMap.put(propertyName, result);  
                }
            }  
        }  
        return returnMap;  
    }  
    
    /** 
     * 将一个 Map 对象转化为一个 JavaBean
     * bean中有的属性 如果map中有对应的key 就会赋值对应的value到bean对应的属性
     *  
     * @param obj 要转化的类型
     * @param map 包含属性值的 map 
     * @return 转化出来的 JavaBean 对象 
     */  
    public static void map2bean(Map<String, Object> map, Object obj) {  
    	
    	Assert.notNull(obj, "obj must not be null");
    	
        BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());
		} catch (IntrospectionException e) {
			return;
		} // 获取类属性  
  
        // 给 JavaBean 对象的属性赋值  
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();  
        for (PropertyDescriptor descriptor : propertyDescriptors) {  
            String propertyName = descriptor.getName();  
  
            if (map.containsKey(propertyName)) {  
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。  
                Object value = map.get(propertyName);  
  
                Object[] args = new Object[1];  
                args[0] = value;  
  
                try {
					descriptor.getWriteMethod().invoke(obj, args);
				} catch (Exception e) {
				}
            }  
        }  
    }  
	
}
