package com.bw.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.bw.exception.AsserUtil;
import com.bw.exception.CRuntimeException;

public class TestAsserUtil {
	@Test
	public void Istrue(){
		try {
			AsserUtil.Istrue(true, "这不是true");
		} catch (CRuntimeException e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	@Test
	public void Isfalse(){
		try {
			AsserUtil.Isfalse(true, "这不是false");
		} catch (CRuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	@Test
	public void Isnull(){
		try {
			AsserUtil.isNotNull("", "为空");
		} catch (CRuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	
	@Test
	public void collectionNotNull(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		try {
			AsserUtil.collectionNotNull(list, "为空");
		} catch (CRuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void MapNotNull(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("123", 1);
		try {
			AsserUtil.MapNotNull(map, "为空");
		} catch (CRuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void isLength(){
		try {
			AsserUtil.isLength(" 1", "字符串没有值");
		} catch (CRuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void isZheng(){
		try {
			AsserUtil.isZheng(1, "不是正数");
		} catch (CRuntimeException e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void testDouble(){
		double x=66.7;
		double y=100;
		System.out.println(x*y);
		BigDecimal b=new BigDecimal("66.77");
		BigDecimal b2=new BigDecimal("100");
		System.out.println(b.multiply(b2));
		System.out.println(b.subtract(b2));
		System.out.println(b.add(b2));
		System.out.println(b.divide(b2));
		String[] split = "1,2,3,4,5,6".split(",");
		for (String string : split) {
			System.out.println(1+string);
		}
		String substring = "123 456".substring(0, 2);
		System.out.println(substring);
		System.out.println("123456".startsWith("2", 1));
		System.out.println();
		int[] num = {1,2,3,4,5,6};
		
		
	}
	@Test
	public void test(){
		HashMap<?, ?> map = new HashMap<>();
		ArrayList<?> list = new ArrayList<>();
	}
}
