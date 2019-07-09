package com.bw.service;

import javax.servlet.http.HttpSession;

import com.bw.bean.User;

public interface UserService {

	int zhuce(User user);

	int login(User user, HttpSession session, String uname);

}
