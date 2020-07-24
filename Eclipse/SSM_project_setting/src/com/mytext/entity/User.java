package com.mytext.entity;

import org.springframework.stereotype.Component;

@Component
public class User {
	private long id;
	private String username;//ÓÃ»§Ãû
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}
	
}
