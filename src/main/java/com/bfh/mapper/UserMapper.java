package com.bfh.mapper;

import com.bfh.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author wcc
 * @Time 2019/09/24
 * @Description: 用户mapper
 */
public interface UserMapper {

    @Insert("INSERT INTO t_user VALUES(NULL,#{email},#{userPassword},#{userName},#{userImage},#{userMood},0)")
    @Options(useGeneratedKeys = true, keyProperty = "uid", keyColumn = "uid")
    void insertUser(User user);

    @Select("SELECT uid FROM t_user WHERE email = #{email}")
    Integer checkEmailUsed(@Param("email") String email);

    @Select("SELECT uid,email,userName,userImage,userMood,userGrade FROM t_user WHERE email = #{email} AND userPassword = #{userPassword}")
    User login(User user);

    @Select("SELECT uid,email,userPassword,userName,userImage,userMood,userGrade FROM t_user WHERE email = #{userName}")
    User getUserByUsername(@Param("userName") String userName);
}
