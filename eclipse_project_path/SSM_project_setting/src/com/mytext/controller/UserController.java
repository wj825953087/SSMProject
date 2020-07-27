package com.mytext.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.BootstrapWith;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mytext.Service.impl.UserServiceImpl;
import com.mytext.entity.User;

import net.sf.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.mytext.Service.UserService;

@Controller
@RequestMapping("user")
public class UserController  {
	@Autowired
	UserService userService;
	@RequestMapping("listUser")
	public ModelAndView listUser(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		List<User> us=userService.list();
		request.setAttribute("user", us);
		
		mav.setViewName("user/hello");
		return mav;
	}
	
	@RequestMapping("listUser2")
	public ModelAndView listUser2(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		List<User> us=userService.list();
		request.setAttribute("user", us);
		
		mav.setViewName("hello");
		return mav;
	}
	@RequestMapping("list")
	public void get(HttpServletResponse response) throws IOException {
		List<User> us=userService.list();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("users", us);
		String mapJson=JSON.toJSONString(map);
		 PrintWriter output= response.getWriter();
		 output.print(mapJson);
		 output.flush();
		 output.close();
		 
	
	}
}
