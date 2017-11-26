package com.bfh.mapper;

import com.bfh.entity.Content;
import com.bfh.vo.ContentVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author bfh
 * @Time 2017/11/16
 * @Description ContentMapper
 */
public interface ContentMapper {

	@Select("SELECT c.*, u.`userName`,u.`userImage` FROM t_content c LEFT JOIN t_user u ON c.`uid` = u.`uid` WHERE mid = #{mid}")
	@Results({
			@Result(property = "contentTime", column = "content_time")
	})
	List<ContentVo> getContentByMid(@Param("mid") Integer mid);

	@Insert("INSERT INTO t_content VALUES(NULL,#{uid},#{mid},#{content},#{contentTime})")
	void insertComment(Content content);
}
