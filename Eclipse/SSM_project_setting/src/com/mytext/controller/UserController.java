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
import com.mytext.Service.UserService;
import com.mytext.entity.User;

@Controller(value = "userController")
@RequestMapping("/user/")
public class UserController  {
	@Resource(name = "userService")
	private UserService userService;
	private List<User> lists=new ArrayList<User>();
	
	@RequestMapping(value = "/hello")
	public String findAll(HttpServletRequest request) {
		//lists=userService.findAll();
		System.out.println("userService:"+userService);
		request.setAttribute("list", lists);
		request.setAttribute("msg", "xxxxx");
		return "/user/hello";
	}
	
}
