package com.bw.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService service;
	@RequestMapping("/tologin.do")
	public String tologin(){
		return "login";
	}
}
