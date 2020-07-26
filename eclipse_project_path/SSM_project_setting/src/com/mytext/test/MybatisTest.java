package com.mytext.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mytext.dao.UserDao;
import com.mytext.entity.User;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testList() {
		System.out.println(userDao);
		List<User> cs=userDao.list();
		for (User c : cs) {
			System.out.println(c.toString());
		}
	}

}
