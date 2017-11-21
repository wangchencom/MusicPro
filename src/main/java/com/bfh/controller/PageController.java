package com.bfh.controller;

import com.bfh.service.MusicService;
import com.bfh.vo.MusicTopVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author bfh
 * @Time 2017/11/8
 * @Description: 用户页面跳转Controller
 */

@Controller
public class PageController {

	@Autowired
	private MusicService musicService;

	/**
	 * 跳转到歌曲搜索结果界面
	 */
	@RequestMapping("/searchResult")
	public String searchResult() {
		return "music/searchResult";
	}

	/**
	 * 跳转到用户详情界面
	 */
	@RequestMapping("/user/profile")
	public String userProfile() {
		return "user/profile";
	}

	/**
	 * 跳转到注册界面
	 */
	@RequestMapping("/user/register")
	public String userRegister() {
		return "register";
	}

	/**
	 * 跳转到登陆界面
	 */
	@RequestMapping("/user/login")
	public String userLogin() {
		return "login";
	}


	/**
	 * 跳转到404界面
	 */
	@RequestMapping("/404")
	public String errorUI() {
		return "404";
	}

	/**
	 * 测试：iframe化播放器
	 */
	@RequestMapping("/music")
	public String music() {
		return "music";
	}

	/**
	 * 跳转到内容页
	 */
	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	/**
	 * 跳转到首页
	 */
	@RequestMapping({"/","/index"})
	public String index(HttpSession session) {
		//初始化内容页内容

		//暂时不做缓存处理
		List<MusicTopVo> likeTops = musicService.getLikeTop();
		if (likeTops != null) {
			session.setAttribute("likeTops", likeTops);
		}

		List<MusicTopVo> uploadTops = musicService.getUploadTop();
		if (uploadTops != null) {
			session.setAttribute("uploadTops", uploadTops);
		}

		List<MusicTopVo> clickRateTops = musicService.getClickRateTop();
		if (clickRateTops != null) {
			session.setAttribute("clickRateTops", clickRateTops);
		}

		return "index";
	}
}
