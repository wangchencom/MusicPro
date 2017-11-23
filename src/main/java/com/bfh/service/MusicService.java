package com.bfh.service;

import com.bfh.entity.Music;
import com.bfh.vo.ContentVo;
import com.bfh.vo.MusicTopVo;
import com.bfh.vo.MusicVo;
import com.bfh.vo.Song;

import java.util.List;

/**
 * @Author bfh
 * @Time 2017/11/12
 * @Description 音乐业务层接口
 */
public interface MusicService {







	void updateClickRate(Integer mid);

	Music downloadMusic(Integer mid);

	List<Music> searchMusic(String searchText);

	List<ContentVo> getContentByMid(Integer mid);

	Boolean putEvaluate(Integer mid, Integer uid, Integer state);

	MusicVo getMusicInfo(Integer id);

	Song getMusicById(Integer id);

	void uploadMusic(Music music);

}
