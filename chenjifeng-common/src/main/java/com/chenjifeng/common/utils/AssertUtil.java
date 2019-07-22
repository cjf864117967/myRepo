package com.chenjifeng.common.utils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

public class AssertUtil {
	/**
	 * 
	 * @Title: 断言为真 
	 * @Description: TODO
	 * @param condition
	 * @param message
	 * @return: void
	 */
	public static void isTure(boolean condition,String message) {
		if(!condition){
			throw new CRuntimeException(message);
		}
	}
	
	/**
	 * 
	 * @Title: 断言为假 
	 * @Description: TODO
	 * @param condition
	 * @param message
	 * @return: void
	 */
	public static void isFalse(boolean condition,String message) {
		if(condition){
			throw new CRuntimeException(message);
		}
	}
	/**
	 * 
	 * @Title: 断言对象不为空 
	 * @Description: TODO
	 * @param obj
	 * @param message
	 * @return: void
	 */
	public static void notNull(Object obj,String message) {
		if(obj==null){
			throw new CRuntimeException(message);
		}
	}
	
	/**
	 * 
	 * @Title: 断言对象必须空 
	 * @Description: TODO
	 * @param obj
	 * @param message
	 * @return: void
	 */
	public static void isNull(Object obj,String message) {
		if(obj!=null){
			throw new CRuntimeException(message);
		}
	}
	
	/**
	 * 
	 * @Title: 断言集合不为空,对象不能空,以及必须包含1个元素 
	 * @Description: TODO
	 * @param coll
	 * @param message
	 * @return: void
	 */
	public static void notEmpty(Collection<?> coll,String message) {
		if(coll==null||coll.size()==0){
			throw new CRuntimeException(message);
		}
	}
	
	/**
	 * 
	 * @Title: 断言Map集合不为空 
	 * @Description: TODO
	 * @param map
	 * @param message
	 * @return: void
	 */
	public static void notEmptyMap(Map<?, ?> map,String message) {
		if(map==null||map.size()==0){
			throw new CRuntimeException(message);
		}
	}
	
	/**
	 * 
	 * @Title: 断言字符串必须有值 
	 * @Description: TODO
	 * @param condition
	 * @param message
	 * @return: void
	 */
	public static void hasText(String condition,String message) {
		if(condition.trim().length()==0){
			throw new CRuntimeException(message);
		}
	}
	/**
	 * 
	 * @Title: hasText2 
	 * @Description: 断言字符串长度不能小于6
	 * @param condition
	 * @param message
	 * @return: void
	 */
	public static void hasText2(String condition,String message) {
		if(condition.trim().length()<6){
			throw new CRuntimeException(message);
		}
	}
	
	/**
	 * 
	 * @Title: 断言值必须大于0
	 * @Description: TODO
	 * @param value
	 * @param message
	 * @return: void
	 */
	public static void greaterThanZero(BigDecimal value,String message) {
		BigDecimal bigDecimal = new BigDecimal(0);
		if(value.compareTo(bigDecimal)<=0){
			throw new CRuntimeException(message);
		}
	}
	
	
	/**
	 * 
	 * @Title: num 
	 * @Description: 循环输出6位1-10之间的随机数
	 * @return
	 * @return: String
	 */
	public static String num(){
		String str="";
		for (int i = 0; i < 6; i++) {
			long random = (long) Math.floor(Math.random()*9);
			
			str+=String.valueOf(random);
		}
		return str;
	}
	
	
	
	
}
