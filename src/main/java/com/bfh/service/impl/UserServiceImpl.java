package com.bfh.service.impl;

import com.bfh.entity.User;
import com.bfh.mapper.UserMapper;
import com.bfh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author bfh
 * @Time 2017/11/9
 * @Description: 用户业务层
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(User user) {
		if (StringUtils.isEmpty(user.getEmail()) ||
				StringUtils.isEmpty(user.getUserPassword())) {
			return null;
		}
		return userMapper.login(user);
	}


	@Override
	public User getUserByUsername(String userName) {
		if (StringUtils.isEmpty(userName)) {
			return null;
		}
		return userMapper.getUserByUsername(userName);
	}
}
