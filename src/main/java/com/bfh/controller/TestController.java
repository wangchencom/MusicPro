package com.bfh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author bfh
 * @Time 2017/11/6
 * 项目构建前期测试所用
 */

@Controller
public class TestController {

	@RequestMapping({"/","/index"})
	public String index() {
		return "index";
	}
}
