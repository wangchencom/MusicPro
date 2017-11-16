package com.bfh.service;

import com.bfh.entity.Music;
import com.bfh.vo.MusicVo;
import com.bfh.vo.Song;

/**
 * @Author bfh
 * @Time 2017/11/12
 * @Description 音乐业务层接口
 */
public interface MusicService {

	Boolean putEvaluate(Integer mid, Integer uid, Integer state);

	MusicVo getMusicInfo(Integer id);

	Song getMusicById(Integer id);

	void uploadMusic(Music music);

}
