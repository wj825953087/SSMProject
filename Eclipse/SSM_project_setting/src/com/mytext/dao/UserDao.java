package com.mytext.dao;

import org.springframework.stereotype.Repository;

import com.mytext.entity.User;
@Repository
public interface UserDao {
	public User getUserById(int id);
}
