package com.bfh.service;

import com.bfh.entity.Content;
import com.bfh.entity.User;
import com.bfh.entity.UserGrade;
import com.bfh.vo.RegisterVo;

/**
 * @Author bfh
 * @Time 2017/11/9
 * @Description: 用户业务层接口
 */
public interface UserService {

	void updateUserGrade();

	UserGrade getUserGrade();

	Boolean insertComment(Content content);

	Boolean register(RegisterVo registerVo);

	Boolean checkEmailUsed(String email);

	User login(User user);

	User getUserByUsername(String userName);
}
