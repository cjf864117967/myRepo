package com.chenjifeng.common.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.chenjifeng.common.utils.AssertUtil;
import com.chenjifeng.common.utils.CRuntimeException;

public class TestAssert {
	
	//断言为真
	@Test
	public void isTrue(){
		try {
			AssertUtil.isTure(true, "未通过断言,为假");
		} catch (CRuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//断言为假
	@Test
	public void isFalse(){
		try {
			AssertUtil.isFalse(false, "未通过断言,为真");
		} catch (CRuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//断言对象不为空 
	@Test
	public void notNull(){
		try {
			AssertUtil.notNull(null, "未通过断言,为空");
		} catch (CRuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//断言对象必须空
	@Test
	public void isNull(){
		try {
			AssertUtil.isNull(null, "未通过断言,不为空");
		} catch (CRuntimeException e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//断言集合不为空,对象不能空,以及必须包含1个元素 
	@Test
	public void notEmpty(){
		Collection<String> coll = new ArrayList<>();
		coll.add("123456");
		try {
			AssertUtil.notEmpty(coll, "未通过断言,为空");
		} catch (CRuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// 断言Map集合不为空 
	@Test
	public void notEmptyMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("123456", "str");
		try {
			AssertUtil.notEmptyMap(map, "未通过断言,为空");
		} catch (CRuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	//断言字符串必须有值 
	@Test
	public void hasText(){
		try {
			AssertUtil.hasText("123456 ", "未通过断言,无值");
		} catch (CRuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//断言值必须大于0
	@Test
	public void greaterThanZero(){
		BigDecimal bigDecimal = new BigDecimal("10");
		BigDecimal bigDecimal2 = new BigDecimal("0");
		BigDecimal bigDecimal3 = new BigDecimal("-3");
		try {
			AssertUtil.greaterThanZero(bigDecimal, "未通过断言,小于或等于0");
		} catch (CRuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
