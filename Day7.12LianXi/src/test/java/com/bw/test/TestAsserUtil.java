package com.bw.test;

import java.util.ArrayList;
import java.util.HashMap;
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
}
