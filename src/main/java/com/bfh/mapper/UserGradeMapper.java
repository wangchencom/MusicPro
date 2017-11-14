package com.bfh.mapper;

import com.bfh.entity.UserGrade;
import org.apache.ibatis.annotations.Insert;

/**
 * @Author bfh
 * @Time 2017/11/13
 * @Description UserGradeMapper
 */
public interface UserGradeMapper {

	@Insert("INSERT INTO t_user_grade VALUES(NULL,#{uid},#{grade},#{score})")
	void insertUserGrade(UserGrade userGrade);
}
