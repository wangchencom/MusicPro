package com.bfh.service.impl;

import com.bfh.entity.Music;
import com.bfh.entity.MusicInfo;
import com.bfh.entity.User;
import com.bfh.mapper.MusicInfoMapper;
import com.bfh.mapper.MusicMapper;
import com.bfh.service.MusicService;
import com.bfh.vo.Song;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author bfh
 * @Time 2017/11/12
 * @Description 音乐业务层接口
 */
@Service
public class MusicServiceImpl implements MusicService {

	@Autowired
	private MusicMapper musicMapper;
	@Autowired
	private MusicInfoMapper musicInfoMapper;


	@Override
	public Song getMusicById(Integer id) {
		if (id != 0) {
			return musicMapper.getMusicById(id);
		}
		return null;
	}

	@Override
	public void uploadMusic(Music music) {
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		music.setUploadUser(user.getUid());
		music.setUploadTime(new Date());
		musicMapper.uploadMusic(music);
		//初始化音乐其他信息
		MusicInfo musicInfo = new MusicInfo();
		musicInfo.setMid(music.getMid());
		musicInfo.setMusicImage("/images/m0.jpg");//日后添加图片路径
		musicInfo.setClickRate(1);
		musicInfo.setDownloads(0);
		musicInfo.setLike(0);
		musicInfo.setDislike(0);
		musicInfoMapper.insertMusicInfo(musicInfo);

	}
}
