package com.bfh.controller;

import com.bfh.vo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author bfh
 * @Time 2017/11/6
 * 项目构建前期测试所用
 */

@Controller
public class TestController {

	@RequestMapping("/getSongs")
	public @ResponseBody List<Song> getSongs() {


		Song song = new Song();

		song.setTitle("China-P");
		song.setArtist("徐梦圆");
		song.setMp3("music/徐梦圆 - China-P.mp3");
		song.setPoster("images/m0.jpg");

		Song song1 = new Song();

		song1.setTitle("If I were a Bird");
		song1.setArtist("黒石ひとみ");
		song1.setMp3("music/黒石ひとみ - If I were a Bird.mp3");
		song1.setPoster("images/m0.jpg");

		List<Song> list = new LinkedList<>();
		list.add(song);
		list.add(0, song1);//添加元素到栈顶

		return list;
	}


	@RequestMapping({"/","/index"})
	public String index() {
		return "index";
	}
}
