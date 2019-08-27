package com.slcupc.entity;

public class UserBean {
	private String username;
	private String pwd;
	public UserBean() {}
	public UserBean(String username, String pwd) {
		this.pwd = pwd;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
