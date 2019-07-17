package com.bw.test;

import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

import com.bw.utils.DateUtil;

public class TestDateUtil {
	
	@Test
	public void getAge(){
		Date src = null;
		int age = DateUtil.getAge(src);
		System.out.println(age);
	}
	
	
	@Test
	public void getDateByMonthInit(){
		Date src=null;
		Scanner sc = new Scanner(System.in);
		String next = sc.next();
		int dateByMonthInit = DateUtil.getDateByMonthInit(src);
		System.out.println(dateByMonthInit);
	}
	
	@Test
	public void getDateByMonthLast(){
		Date src=null;
		int dateByMonthLast = DateUtil.getDateByMonthLast(src);
		System.out.println(dateByMonthLast);
	}
	
	@Test
	public void getDaysByFuture(){
		
		Date future=null;
		int daysByFuture = DateUtil.getDaysByFuture(future);
		System.out.println(daysByFuture);
	}
	
	@Test
	public void getDaysByDeparted(){
		Date departed=null;
		int daysByDeparted = DateUtil.getDaysByDeparted(departed);
		System.out.println(daysByDeparted);
	}
}
