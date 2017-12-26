package com.bfh.mapper;

import com.bfh.entity.Music;
import com.bfh.vo.MusicTopVo;
import com.bfh.vo.MusicVo;
import com.bfh.vo.Song;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author bfh
 * @Time 2017/11/12
 * @Description MusicMapper
 */
public interface MusicMapper {


	@Select("SELECT eid FROM t_evaluate WHERE mid = #{mid} AND uid = #{uid}")
	Integer checkEvaluate(@Param("mid") Integer mid, @Param("uid") Integer uid);


	@Insert("INSERT INTO t_evaluate VALUES(NULL,#{mid},#{uid},#{state})")
	void putEvaluate(@Param("mid") Integer mid, @Param("uid") Integer uid, @Param("state") Integer state);


	@Select("SELECT m.`mid`,m.`music_name`,mi.`user_like`,mi.`user_dislike` FROM t_music m LEFT JOIN t_music_info mi ON m.`mid` = mi.`mid` WHERE m.`mid` = #{id}")
	MusicVo getMusicInfo(Integer id);

	@Select("SELECT m.`music_name`,m.`path_name`,mi.`musicImage` FROM t_music m LEFT JOIN t_music_info mi ON m.`mid` = mi.`mid` WHERE m.`mid` = #{id}")
	Song getMusicById(Integer id);

	@Insert("INSERT INTO t_music VALUES(NULL,#{musicName},#{pathName},#{uploadUser},#{uploadTime})")
	@Options(useGeneratedKeys = true, keyProperty = "mid", keyColumn = "mid")
	void uploadMusic(Music music);
}
