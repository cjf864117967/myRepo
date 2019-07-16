package com.bw.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;

import org.junit.Test;

import com.bw.utils.StreamUtil;

public class TestStreamUtil {
	@Test
	public void closeAll() throws IOException{
		Closeable closeables = null;
		StreamUtil.closeAll(closeables);
	}
	
	@Test
	public void copy() throws IOException{
		boolean isCloseOutputStream = true;
		BufferedInputStream src = null;
		BufferedOutputStream out = null;
		boolean isCloseInputStream = true;
		
		StreamUtil.copy(src, out, isCloseInputStream, isCloseOutputStream);
	}
	
	@Test
	public void readTextFile() throws IOException{
		BufferedInputStream src = null;
		String readTextFile = StreamUtil.readTextFile(src);
	}
	
	@Test
	public void readTextFile1() throws IOException{
		BufferedInputStream txtFile = null;
		String readTextFile = StreamUtil.readTextFile(txtFile);
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void readStringFromSystemIn(String message){
		String readStringFromSystemIn = StreamUtil.readStringFromSystemIn(message);
	}
	
	
	@Test
	public void readIntFromSystemIn(String message){
		
		int readIntFromSystemIn = StreamUtil.readIntFromSystemIn(message);
	}
}
