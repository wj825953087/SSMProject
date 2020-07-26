package com.mytext.Service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytext.dao.UserDao;
import com.mytext.entity.User;
import com.mytext.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}

}
