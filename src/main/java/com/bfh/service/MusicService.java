package com.bfh.service;

import com.bfh.entity.Music;
import com.bfh.vo.Song;

/**
 * @Author bfh
 * @Time 2017/11/12
 * @Description 音乐业务层接口
 */
public interface MusicService {

	Song getMusicById(Integer id);

	void uploadMusic(Music music);

}
