package com.bw.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.bean.User;
import com.bw.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService service;
	@RequestMapping("/tozhuce.do")
	public String tozhuce(){
		return "zhuce";
	}
	
	@RequestMapping("/tologin.do")
	public String tologin(){
		return "login";
		
	}
	
	@RequestMapping("/zhuce.do")
	@ResponseBody
	public Integer zhuce(User user){
		int num = service.zhuce(user);
		return num;
		
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public Integer login(User user,HttpSession session,String uname){
		int num = service.login(user,session,uname);
		return num;
	}
}
