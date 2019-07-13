package com.bw.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AsserUtil {
	/**
	 * 
	 * @Title: Istrue 
	 * @Description: TODO
	 * @param exp
	 * @param message
	 * @return: void
	 */
	public static void Istrue(boolean exp,String message) {
		if(!exp){
			 throw new CRuntimeException(message);
		}
	}
	/**
	 * 
	 * @Title: Isfalse 
	 * @Description: TODO
	 * @param exp
	 * @param message
	 * @return: void
	 */
	public static void Isfalse(boolean exp,String message) {
		if(exp){
			throw new CRuntimeException(message);
		}
	}
	
	public static void isNotNull(Object exp,String message){
		if(exp==null){
			throw new CRuntimeException(message);
		}
	}
	/**
	 * 
	 * @Title: 断言List,Set集合不为空 
	 * @Description: TODO
	 * @return: void
	 */
	public static void collectionNotNull(ArrayList list,String message) {
		if(list.size()==0){
			
			throw new CRuntimeException(message);
		}
	}
	/**
	 * 
	 * @Title: MapNotNull 
	 * @Description: 断言 Map 集合不为空
	 * @param map
	 * @param message
	 * @return: void
	 */
	public static void MapNotNull(Map map,String message) {
		if(map.size()==0){
			throw new CRuntimeException(message);
		}
	}
	/**
	 * 
	 * @Title: isLength 
	 * @Description: 断言字符串必须有值，去掉空格后，长度必须大于 0
	 * @param exp
	 * @param message
	 * @return: void
	 */
	public static void isLength(String exp,String message) {
		if(!(exp.trim().length()>0)){
			throw new CRuntimeException(message);
		}
	}
	/**
	 * 
	 * @Title: isZheng 
	 * @Description: 断言值必须是正数(值大于 0)
	 * @param exp
	 * @param message
	 * @return: void
	 */
	public static void isZheng(Integer exp,String message) {
		if(!(exp>0)){
			throw new CRuntimeException(message);
		}
	}
}
