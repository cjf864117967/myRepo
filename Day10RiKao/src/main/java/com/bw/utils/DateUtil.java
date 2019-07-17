package com.bw.utils;

import java.util.Date;

public class DateUtil {
	
	/**
	 * 
	 * @Title: 根据传入的日期获取年龄 
	 * @Description: TODO
	 * @param src
	 * @return
	 * @return: int
	 */
	public static int getAge (Date src) {
		int year = src.getYear();
		return year;
		
	}
	
	/**
	 * 
	 * @Title: 根据传入的参数获取该日期的月初日期 
	 * @Description: TODO
	 * @param src
	 * @return
	 * @return: Date
	 */
	public static int getDateByMonthInit (Date src) {
		int month = src.getMonth();
		return month;
		
	}
	
	/**
	 * 
	 * @Title: 根据传入的参数获取该日器的月末日期 
	 * @Description: TODO
	 * @param src
	 * @return
	 * @return: Date
	 */
	public static int getDateByMonthLast(Date src) {
		int month = src.getMonth();
		return month;
		
	}
	
	
	
	/**
	 * 
	 * @Title: 求未来日期离今天还剩的天数 
	 * @Description: TODO
	 * @param future
	 * @return
	 * @return: int
	 */
	public static int getDaysByFuture (Date future) {
		long time = future.getTime();
		Date date = new Date();
		int day = date.getDay();
		int number = (int) (time-day);
		return number;
	}
	
	
	/**
	 * 
	 * @Title: 求过去日期离今天过去的天数 
	 * @Description: TODO
	 * @param departed
	 * @return
	 * @return: int
	 */
	public static int getDaysByDeparted (Date departed) {
		long time = departed.getTime();
		Date date = new Date();
		int day = date.getDay();
		int number = (int) (day-time);
		return number;
		
	}
}
