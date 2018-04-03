package com.yibo.zhang.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled =true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//���е����󣬶���Ҫ����HTTP basic��֤
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		//���ı�����������һ�������κβ������������������spring�ṩ�����������Ĳ��Ե�
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Autowired
	private CustomUserDetailsService userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailService).passwordEncoder(this.passwordEncoder());
	}
}
