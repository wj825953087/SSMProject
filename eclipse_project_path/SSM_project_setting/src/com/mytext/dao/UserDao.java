package com.mytext.dao;

import java.util.List;


import com.mytext.entity.User;

public interface UserDao {
	public User getUserById(int id);
	
	public List<User> list();
}
