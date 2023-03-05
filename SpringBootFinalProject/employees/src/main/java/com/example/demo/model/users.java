
package com.example.demo.model;

public class users {

	String username;
	String password;
	
	public users() {
		super();
	}


	public users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "users [username=" + username + ", password=" + password + "]";
	}
	
}

