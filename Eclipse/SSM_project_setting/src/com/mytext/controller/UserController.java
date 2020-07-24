package com.mytext.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mytext.Service.UserService;
import com.mytext.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	private List<User> list=new ArrayList<User>();
	@RequestMapping(value = "/out" ,method = RequestMethod.POST)
	public String getUserById(HttpServletRequest request)throws Exception {
		
		request.setAttribute("list", "null");
		return "/user/out";
	}
}
