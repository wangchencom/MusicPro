package com.bfh.service.impl;

import com.bfh.entity.Music;
import com.bfh.entity.MusicInfo;
import com.bfh.entity.User;
import com.bfh.mapper.ContentMapper;
import com.bfh.mapper.MusicInfoMapper;
import com.bfh.mapper.MusicMapper;
import com.bfh.mapper.UserGradeMapper;
import com.bfh.service.MusicService;
import com.bfh.utils.ConstUtil;
import com.bfh.vo.ContentVo;
import com.bfh.vo.MusicTopVo;
import com.bfh.vo.MusicVo;
import com.bfh.vo.Song;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author wcc
 * @Time 2019/09/24
 * @Description 音乐业务层接口
 */
@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicMapper musicMapper;
    @Autowired
    private MusicInfoMapper musicInfoMapper;
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private UserGradeMapper userGradeMapper;


    @Override
    public List<MusicTopVo> getLikeTop() {
        return musicMapper.getLikeTop();
    }

    @Override
    public List<MusicTopVo> getUploadTop() {
        return musicMapper.getUploadTop();
    }

    @Override
    public List<MusicTopVo> getClickRateTop() {
        return musicMapper.getClickRateTop();
    }

    @Override
    public void updateClickRate(Integer mid) {
        if (mid != null) {
            musicMapper.updateClickRate(mid);
        }
    }

    @Override
    public Music downloadMusic(Integer mid) {
        if (mid != null && mid != 0) {

            User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
            //下载前检查积分够不够
            Integer score = userGradeMapper.getScoreByUid(user.getUid());
            int currentScore = score - ConstUtil.DOWNLOAD_MUSIC_SCORE;
            if (currentScore < 0) {
                return null;
            }
            Music music = musicMapper.downloadMusic(mid);
            //更新下载次数
            musicInfoMapper.updateDownload(mid);
            //下载积分扣除

            userGradeMapper.deductionScore(ConstUtil.DOWNLOAD_MUSIC_SCORE, user.getUid());

            return music;
        }
        return null;
    }

    @Override
    public List<Music> searchMusic(String searchText) {
        List<Music> list = null;
        if (!StringUtils.isEmpty(searchText)) {
            list = musicMapper.searchMusic(searchText);
        }
        return list;
    }

    @Override
    public List<ContentVo> getContentByMid(Integer mid) {
        if (mid != 0) {
            return contentMapper.getContentByMid(mid);
        }
        return null;
    }

    @Override
    public Boolean putEvaluate(Integer mid, Integer uid, Integer state) {
        //非空判断
        if (mid != 0 && uid != 0 && state != null) {

            //先检查用户是否点过赞
            Integer eid = musicMapper.checkEvaluate(mid, uid);
            if (eid == null) {
                //添加用户点赞记录
                musicMapper.putEvaluate(mid, uid, state);

                //更新like  dislike
                if (state == 0) {
                    musicInfoMapper.updateLike(mid);
                } else {
                    musicInfoMapper.updateDislike(mid);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public MusicVo getMusicInfo(Integer id) {
        if (id != null && id != 0) {
            return musicMapper.getMusicInfo(id);
        }
        return null;
    }

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

        //用户积分添加
        userGradeMapper.addScore(ConstUtil.UPLOAD_MUSIC_SCORE, user.getUid());

    }
}
