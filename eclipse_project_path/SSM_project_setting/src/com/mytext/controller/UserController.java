package com.mytext.controller;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mytext.Service.impl.UserServiceImpl;
import com.mytext.entity.User;
import com.mytext.Service.UserService;

@Controller
@RequestMapping("")
public class UserController  {
	@Autowired
	UserService userService;
	@RequestMapping("listUser")
	public ModelAndView listUser(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		List<User> us=userService.list();
		request.setAttribute("user", us);
		
		mav.setViewName("hello");
		return mav;
	}
}
