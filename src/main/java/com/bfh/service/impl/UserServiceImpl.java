package com.bfh.service.impl;

import com.bfh.entity.User;
import com.bfh.mapper.UserMapper;
import com.bfh.service.UserService;
import com.bfh.vo.RegisterVo;
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
	public Boolean register(RegisterVo registerVo) {
		User user = null;
		//非空判断，自只做部分非空判断
		if (!StringUtils.isEmpty(registerVo.getEmail()) || !StringUtils.isEmpty(registerVo.getFirst_password())) {
			//两次密码是否一致
			if (registerVo.getFirst_password().equals(registerVo.getSecond_password())) {
				user = new User();
				user.setUserName(registerVo.getUserName());
				user.setEmail(registerVo.getEmail());
				user.setUserPassword(registerVo.getFirst_password());
				user.setUserImage("/images/m0.jpg");
				user.setUserMood("太阳当空照，花儿对我笑");
				userMapper.insertUser(user);
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean checkEmailUsed(String email) {
		Integer uid = userMapper.checkEmailUsed(email);
		return uid != null;
	}

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
