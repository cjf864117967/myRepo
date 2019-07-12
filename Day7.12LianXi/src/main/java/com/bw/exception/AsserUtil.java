package com.bw.exception;

public class AsserUtil {
	public static void Istrue(boolean exp,String message) {
		if(!exp){
			 throw new CRuntimeException(message);
		}
	}
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
}
