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
	 * 跳转到登陆界面
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}


	/**
	 * 跳转到注册界面
	 */
	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	/**
	 * 跳转到首页
	 */
	@RequestMapping({"/","/index"})
	public String index() {
		return "index";
	}
}
