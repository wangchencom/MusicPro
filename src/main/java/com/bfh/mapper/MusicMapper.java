package com.bfh.mapper;

import com.bfh.entity.Music;
import com.bfh.vo.MusicTopVo;
import com.bfh.vo.MusicVo;
import com.bfh.vo.Song;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author wcc
 * @Time 2019/09/24
 * @Description MusicMapper
 */
public interface MusicMapper {


    @Select("SELECT m.`mid`,m.`music_name`,mi.`musicImage`, mi.`user_like` FROM t_music m LEFT JOIN t_music_info mi ON m.`mid` = mi.`mid` LIMIT 10")
    @Results(id = "MusicTopVoMap", value = {
            @Result(property = "mid", column = "mid"),
            @Result(property = "musicName", column = "music_name"),
            @Result(property = "musicImage", column = "musicImage")
    })
    List<MusicTopVo> getLikeTop();


    @Select("SELECT m.`mid`,m.`music_name`,mi.`musicImage`, m.`upload_time` FROM t_music m LEFT JOIN t_music_info mi ON m.`mid` = mi.`mid` ORDER BY m.`upload_time` DESC LIMIT 10")
    @ResultMap("MusicTopVoMap")
    List<MusicTopVo> getUploadTop();


    @Select("SELECT m.`mid`,m.`music_name`,mi.`musicImage`, mi.`clickRate` FROM t_music m LEFT JOIN t_music_info mi ON m.`mid` = mi.`mid` ORDER BY mi.`clickRate` DESC LIMIT 10")
    @ResultMap("MusicTopVoMap")
    List<MusicTopVo> getClickRateTop();


    @Update("UPDATE t_music_info SET clickRate = clickRate + 1 WHERE MID = #{mid}")
    void updateClickRate(@Param("mid") Integer mid);


    @Select("SELECT music_name,path_name FROM t_music WHERE MID = #{mid}")
    @Results({
            @Result(property = "musicName", column = "music_name"),
            @Result(property = "pathName", column = "path_name")
    })
    Music downloadMusic(@Param("mid") Integer mid);


    @Select("SELECT mid,music_name FROM t_music WHERE music_name LIKE '%${searchText}%'")
    @Results({
            @Result(property = "musicName", column = "music_name")
    })
    List<Music> searchMusic(@Param("searchText") String searchText);

    @Select("SELECT eid FROM t_evaluate WHERE mid = #{mid} AND uid = #{uid}")
    Integer checkEvaluate(@Param("mid") Integer mid, @Param("uid") Integer uid);


    @Insert("INSERT INTO t_evaluate VALUES(NULL,#{mid},#{uid},#{state})")
    void putEvaluate(@Param("mid") Integer mid, @Param("uid") Integer uid, @Param("state") Integer state);


    @Select("SELECT m.`mid`,m.`music_name`,mi.`user_like`,mi.`user_dislike` FROM t_music m LEFT JOIN t_music_info mi ON m.`mid` = mi.`mid` WHERE m.`mid` = #{id}")
    @Results({
            @Result(property = "musicName", column = "music_name"),
            @Result(property = "like", column = "user_like"),
            @Result(property = "dislike", column = "user_dislike")
    })
    MusicVo getMusicInfo(Integer id);

    @Select("SELECT m.`music_name`,m.`path_name`,mi.`musicImage` FROM t_music m LEFT JOIN t_music_info mi ON m.`mid` = mi.`mid` WHERE m.`mid` = #{id}")
    @Results({
            @Result(property = "title", column = "music_name"),
            @Result(property = "mp3", column = "path_name"),
            @Result(property = "poster", column = "musicImage")
    })
    Song getMusicById(Integer id);

    @Insert("INSERT INTO t_music VALUES(NULL,#{musicName},#{pathName},#{uploadUser},#{uploadTime})")
    @Options(useGeneratedKeys = true, keyProperty = "mid", keyColumn = "mid")
    void uploadMusic(Music music);
}
