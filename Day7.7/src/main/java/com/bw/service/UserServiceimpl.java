package com.bw.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.bw.bean.User;
import com.bw.mapper.UserDao;

@Service
public class UserServiceimpl implements UserService{
	@Resource
	private UserDao dao;

	@Override
	public int zhuce(User user) {
		// TODO Auto-generated method stub
		return dao.zhuce(user);
	}

	@Override
	public int login(User user, HttpSession session, String uname) {
		// TODO Auto-generated method stub
		User u = dao.login(uname);
		if(u!=null){
			if(u.getUpwd().equals(user.getUpwd())){
				session.setAttribute("user", u);
				return 1;
			}
		}
		return 0;
	}
}
