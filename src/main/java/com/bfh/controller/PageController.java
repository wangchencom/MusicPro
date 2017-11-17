package com.bfh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author bfh
 * @Time 2017/11/8
 * @Description: 用户页面跳转Controller
 */

@Controller
public class PageController {


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
	 * 跳转到首页
	 */
	@RequestMapping({"/","/index"})
	public String index() {
		return "index";
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

	@RequestMapping("/main")
	public String main() {
		return "main";
	}
}
