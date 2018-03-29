package com.yibo.zhang.Model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String username;
	@Column
	private String namecn;
	@Column
	private Integer age;
	@Column
	private BigDecimal balance;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public String getNamecn() {
		return this.namecn;
	}
	public void setNamecn(String namecn) {
		this.namecn=namecn;
	}
	public Integer getAge() {
		return this.age;
	}
	public void setAge(Integer age) {
		this.age=age;
	}
	public BigDecimal getBalance() {
		return this.balance;
	}
	public void setBalance(BigDecimal balance){
		this.balance=balance;
	}
}
