package com.bfh.service;

import com.bfh.entity.User;

/**
 * @Author bfh
 * @Time 2017/11/9
 * @Description: 用户业务层接口
 */
public interface UserService {

	User login(User user);

	User getUserByUsername(String userName);
}
