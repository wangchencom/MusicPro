package com.bfh.controller;

import com.bfh.entity.Music;
import com.bfh.service.MusicService;
import com.bfh.vo.Song;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @Author bfh
 * @Time 2017/11/6
 * 用户在session中获取播放列表
 */

@Controller
public class MusicController {

	private Logger logger =  LoggerFactory.getLogger(this.getClass());


	@Autowired
	private MusicService musicService;


	/**
	 * 音乐详情页面
	 * @param id 音乐id
	 * @return 音乐详情页面
	 */
	@RequestMapping("/music/musicInfo/{id}")
	public String musicInfo(@PathVariable("id") Integer id) {
		logger.info("musicInfo-->"+id);

		return "music/musicInfo";
	}


	/**
	 * 播放音乐模块
	 */
	@RequestMapping("/music/playMusic")
	@ResponseBody
	public String playMusic(HttpSession session,Integer id) {
		logger.info("playMusic-->"+id);
		//返回歌曲名
		Song song = musicService.getMusicById(id);
		//更新正在播放歌曲列表
		List<Song> songs = (List<Song>) session.getAttribute("songs");
		//添加元素到栈顶
		songs.add(0,song);

		return song.getTitle();
	}


	/**
	 * 用户上传音乐模块
	 * @param file 上传的音乐
	 * @return 上传结果
	 */
	@RequestMapping("/music/uploadMusic")
	public @ResponseBody
	String uploadMusic(MultipartFile file) {

		if(!file.isEmpty()){
			String musicFormat = file.getOriginalFilename().split("\\.")[1];
			if ("mp3".equals(musicFormat) || "m4v".equals(musicFormat) || "oga".equals(musicFormat)) {
				String uuid = UUID.randomUUID().toString();
				String fileName = uuid + "." + file.getOriginalFilename().split("\\.")[1];
				String path = "E:\\upload\\MusicPro\\music";
				File f = new File(path, fileName);
				try {
					file.transferTo(f);
					String imagePath = "/upload/music/" + fileName;
					logger.info("----->"+imagePath);

					String musicName = file.getOriginalFilename().split("\\.")[0];
					Music music = new Music();
					music.setMusicName(musicName);
					music.setPathName(imagePath);
					musicService.uploadMusic(music);


				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				return "<h2 style='text-align: center;padding-top: 50px;'>Opps！我们不支持这种格式的歌曲。</h2>";
			}
		}
		return "<h2 style='text-align: center;padding-top: 50px;'>歌曲："+file.getOriginalFilename()+"上传成功！</h2>";
	}


	/**
	 * 获取session中的歌曲列表
	 * @return 歌曲列表
	 */
	@RequestMapping("/getSongs")
	public @ResponseBody List<Song> getSongs(HttpSession session) {

		List<Song> songs = (List<Song>) session.getAttribute("songs");
		if (songs == null) {
			Song song = new Song();
			song.setTitle("徐梦圆 - China-P");
			song.setArtist(null);
			song.setMp3("/upload/music/4199b5a0-9cef-434a-830f-32beae7d6deb.mp3");
			song.setPoster("/images/m0.jpg");
			Song song1 = new Song();
			song1.setTitle("黒石ひとみ - If I were a Bird");
			song1.setArtist(null);
			song1.setMp3("/upload/music/b8d4b205-0174-425c-b411-33fd6f79508e.mp3");
			song1.setPoster("/images/m0.jpg");

			songs = new LinkedList<>();
			songs.add(song);
			songs.add(0, song1);//添加元素到栈顶
			session.setAttribute("songs",songs);
			logger.info("--> 初始化音乐播放器列表");
		}
		return songs;
	}

}
