package com.bfh.controller;

import com.bfh.entity.User;
import com.bfh.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Author bfh
 * @Time 2017/11/9
 * @Description 用户控制层
 */

@Controller
public class UserController {

	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;


	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String login(RedirectAttributes model, User user) {

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getUserPassword());

		try {
			subject.login(token);
			logger.error("-->登陆成功");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			logger.error("-->登陆失败");
			model.addFlashAttribute("errorMsg","用户名或者密码错误...");
			return "redirect:/user/login";

		}
		return "redirect:/";
	}


	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/";
	}


}
