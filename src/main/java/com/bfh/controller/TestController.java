package com.bfh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author bfh
 * @Time 2017/11/6
 */

@RestController
public class TestController {

	@RequestMapping({"/","/index"})
	public String index() {
		return "首页测试";
	}
}
