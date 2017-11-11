package com.bfh.service;

import com.bfh.entity.User;
import com.bfh.vo.RegisterVo;

/**
 * @Author bfh
 * @Time 2017/11/9
 * @Description: 用户业务层接口
 */
public interface UserService {

	Boolean register(RegisterVo registerVo);

	Boolean checkEmailUsed(String email);

	User login(User user);

	User getUserByUsername(String userName);
}
