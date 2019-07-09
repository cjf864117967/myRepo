package com.bw.mapper;

import com.bw.bean.User;

public interface UserDao {

	int zhuce(User user);

	User login(String uname);

}
