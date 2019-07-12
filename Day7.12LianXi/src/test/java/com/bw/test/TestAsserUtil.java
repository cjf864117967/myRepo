package com.bw.test;

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
}
