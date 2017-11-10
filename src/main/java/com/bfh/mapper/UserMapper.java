package com.bfh.mapper;

import com.bfh.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author bfh
 * @Time 2017/11/9
 * @Description: 用户mapper
 */
public interface UserMapper {

	@Select("SELECT uid,email,userName,userImage,userMood,userGrade FROM t_user WHERE email = #{email} AND userPassword = #{userPassword}")
	User login(User user);

	@Select("SELECT uid,email,userPassword,userName,userImage,userMood,userGrade FROM t_user WHERE email = #{userName}")
	User getUserByUsername(@Param("userName") String userName);
}
