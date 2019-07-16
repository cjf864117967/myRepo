package com.bw.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class StreamUtil {
	
	
	/**
	 * 
	 * @Title: closeAll 
	 * @Description: 批量关闭流
	 * @param closeables
	 * @throws IOException
	 * @return: void
	 */
	public static void closeAll(Closeable closeables) throws IOException {
		if(closeables.equals(true)){
			closeables.close();
		}
	}
	
	/**
	 * 
	 * @Title: copy 
	 * @Description: 拷贝流
	 * @param src
	 * @param out
	 * @param isCloseInputStream
	 * @param isCloseOutputStream
	 * @throws IOException
	 * @return: void
	 */
	public static void copy(BufferedInputStream src,BufferedOutputStream  out,boolean isCloseInputStream,boolean isCloseOutputStream) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:/Day9.txt"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:/新建文本文档.txt"));
		int num = 0;
		byte[] by = new byte[1024];
		while((num=bis.read(by))!=0){
			String string = new String(by, 0, num);
			bos.write(by, 0, num);
		}
		if(isCloseInputStream){
			bis.close();
		}
		if(isCloseOutputStream){
			bos.close();
		}
	}
	
	
	/**
	 * 
	 * @Title: readTextFile 
	 * @Description: 传入一个文本文件对象，默认为UTF-8编码，返回该文件内容，要求方法内部调用上面第2个方法拷贝流，结束后第1个方法关闭流
	 * @param src
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readTextFile(BufferedInputStream src) throws IOException {
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("D:/新建文本文档.txt"));
		copy(src, os, true, true);
		Closeable closeables = null ;
		closeAll(closeables);
		return null;
		
	}
	
	/**
	 * 
	 * @Title: readTextFile 
	 * @Description: 传入文本文件对象，返回该文件内容,调用3方法
	 * @param txtFile
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readTextFile(File txtFile) throws IOException {
		BufferedInputStream src = null;
		BufferedOutputStream out = null;
		boolean isCloseInputStream = true;
		boolean isCloseOutputStream = true;
		copy(src, out, isCloseInputStream, isCloseOutputStream);
		String readTextFile = readTextFile(src);
		Closeable closeables = null;
		closeAll(closeables);
		return null;
		
	}
	
	/**
	 * 
	 * @Title: readStringFromSystemIn 
	 * @Description: 从控制台读取用户输入的字符串
	 * @param message
	 * @return
	 * @return: String
	 */
	public static String readStringFromSystemIn(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输出您的姓名");
		String next = sc.next();
		return message;
		
	}
	
	/**
	 * 
	 * @Title: readIntFromSystemIn 
	 * @Description: 从控制台读取用户输入的数字
	 * @param message
	 * @return
	 * @return: int
	 */
	public static int readIntFromSystemIn(String message) {
		System.out.println("请输出您的年龄");
		Scanner sc = new Scanner(System.in);
		int nextInt = sc.nextInt();
		return 0;
	}
}
