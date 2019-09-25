package com.bfh.mapper;

import com.bfh.entity.UserGrade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Author wcc
 * @Time 2019/09/24
 * @Description UserGradeMapper
 */
public interface UserGradeMapper {

    @Update("UPDATE t_user_grade SET grade = #{grade} WHERE uid = #{uid}")
    void updateUserGrade(@Param("grade") Integer grade, @Param("uid") Integer uid);


    @Select("SELECT grade, score FROM t_user_grade WHERE uid = #{uid}")
    UserGrade getUserGrade(@Param("uid") Integer uid);

    @Select("SELECT score FROM t_user_grade WHERE uid = #{uid}")
    Integer getScoreByUid(@Param("uid") Integer uid);


    @Update("UPDATE t_user_grade SET score = score - ${score} WHERE uid = #{uid}")
    void deductionScore(@Param("score") Integer score, @Param("uid") Integer uid);


    @Update("UPDATE t_user_grade SET score = score + ${score} WHERE uid = #{uid}")
    void addScore(@Param("score") Integer score, @Param("uid") Integer uid);

    @Insert("INSERT INTO t_user_grade VALUES(NULL,#{uid},#{grade},#{score})")
    void insertUserGrade(UserGrade userGrade);
}
