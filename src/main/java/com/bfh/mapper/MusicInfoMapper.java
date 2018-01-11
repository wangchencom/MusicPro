package com.bfh.mapper;

import com.bfh.entity.MusicInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @Author bfh
 * @Time 2017/11/13
 * @Description
 */
public interface MusicInfoMapper {



	@Update("UPDATE t_music_info SET user_dislike = user_dislike + 1 WHERE mid = #{mid}")
	void updateDislike(@Param("mid") Integer mid);

	@Insert("INSERT INTO t_music_info VALUES(NULL,#{mid},#{musicImage},#{clickRate},#{downloads},#{like},#{dislike})")
	void insertMusicInfo(MusicInfo musicInfo);
}
