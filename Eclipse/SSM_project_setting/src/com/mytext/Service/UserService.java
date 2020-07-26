package com.mytext.Service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.mytext.entity.User;
@Service
public interface UserService {
	public User getUserById(int id);
	public List<User>findAll();
}
