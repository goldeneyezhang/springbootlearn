package com.yibo.zhang.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

		/**
		 * 模拟二个用户
		 * �˺���user������password1����ɫ��user-role
		 * �˺���admin,����password2,��ɫ��admin-role
		 */
	
	public UserDetails loadUserByUsername(String username) throws
		UsernameNotFoundException {
 		if("user".equals(username)) {
			return new SecurityUser("user","password1","user-role");
		}else if("admin".equals(username)) {
			return new SecurityUser("admin","password2","admin-role");
		}else {
			return null;
		}
	}
}
