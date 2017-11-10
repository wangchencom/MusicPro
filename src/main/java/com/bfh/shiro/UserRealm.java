package com.bfh.shiro;

import com.bfh.entity.User;
import com.bfh.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author bfh
 * @Time 2017/11/9
 * @Description 用户Realm
 */
public class UserRealm extends AuthorizingRealm {

	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	/**
	 * 权限配置,如果只是简单的身份认证没有权限的控制的话，
	 * 那么这个方法可以不进行实现，直接返回null即可
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.error("-->授权：UserRealm.doGetAuthenticationInfo()");

//		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//		User user = (User) principals.getPrimaryPrincipal();
//		/**
//		 * 权限后期添加
//		 */
//		authorizationInfo.addRole("user");
//		authorizationInfo.addStringPermission("user:add");
//		return authorizationInfo;

		return null;
	}



	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		logger.error("-->认证：UserRealm.doGetAuthenticationInfo()");

		String username = (String) token.getPrincipal();
		User user = userService.getUserByUsername(username);
		if (user != null) {
			SecurityUtils.getSubject().getSession().setAttribute("user",user);
			return new SimpleAuthenticationInfo(user.getEmail(), user.getUserPassword(), getName());
		}
		return null;
	}
}
