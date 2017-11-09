package com.bfh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author bfh
 * @Time 2017/11/8
 * @Description: 用户页面跳转Controller
 */

@Controller
public class PageController {


	/**
	 * 页面跳转处理(根目录)
	 */
	@RequestMapping(value = "/page/{url}", method = RequestMethod.GET)
	public String changePage(@PathVariable String url) {
		return url;
	}

	/**
	 * 页面跳转处理(二级目录)
	 */
	@RequestMapping(value = "/page/{url1}/{url2}", method = RequestMethod.GET)
	public String changePageTo(@PathVariable String url1, @PathVariable String url2) {
		return url1 + "/" + url2;
	}


	/**
	 * 跳转到首页
	 */
	@RequestMapping({"/","/index"})
	public String index() {
		return "index";
	}
}
