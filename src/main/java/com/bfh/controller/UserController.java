package com.bfh.controller;

import com.bfh.entity.User;
import com.bfh.service.UserService;
import com.bfh.vo.RegisterVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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


	/**
	 * 用户注册
	 * @param registerVo 注册用户vo
	 * @return true 注册成功，false 注册失败
	 */
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public @ResponseBody
	Boolean register(RegisterVo registerVo) {
		return userService.register(registerVo);
	}


	/**
	 * 检查用户邮箱是否被注册
	 * @return true 被注册  false  没有被注册
	 */
	@RequestMapping("/user/checkName")
	public @ResponseBody
	Boolean checkEmailUsed(String email) {
		return userService.checkEmailUsed(email);
	}


	/**
	 * 用户登录
	 * @param model 携带参数重定向
	 * @param user 绑定用户数据
	 * @return 页面转发/重定向
	 */
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


	/**
	 * 用户注销
	 * @return 页面重定向
	 */
	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/";
	}


}