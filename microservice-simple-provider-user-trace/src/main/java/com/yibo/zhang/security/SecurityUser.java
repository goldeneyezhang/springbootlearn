package com.yibo.zhang.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails{
		private static final long serialVersionUID = 1L;
		public SecurityUser(String username,String password,String role) {
			super();
			this.username=username;
			this.password=password;
			this.role=role;
		}
		public SecurityUser() {
			
		}
		private Long id;
		private String username;
		private String password;
		private String role;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		

		public Collection<? extends GrantedAuthority> getAuthorities(){
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.role);
			authorities.add(authority);
			return authorities;
		}
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		
}
