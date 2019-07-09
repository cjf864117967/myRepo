package com.bw.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.mapper.UserDao;

@Service
public class UserServiceimpl implements UserService{
	@Resource
	private UserDao dao;
}
