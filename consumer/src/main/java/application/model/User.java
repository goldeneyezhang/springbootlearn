package application.model;

import java.math.BigDecimal;

public class User {

	private Integer id;
	private String username;
	private String namecn;
	private Integer age;
	private BigDecimal balance;
	
	//getters and setters
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
