package com.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;
import com.vo.User;

public class TestUserDaoImpl {
	 private  IUserDao   userDao=new UserDaoImpl();
	@Test
	
	public void testAdd() {
		userDao.add(new User(null, "小红", "123", "女", "123456789", "xiaohong@qq.com", "是"));
	}

	@Test
	public void testDelete() {
		userDao.delete(34);
	}

	@Test
	public void testUpdate() {
		userDao.update(new User(34, "小芳", "222", "女", "11111111", "xiaofang@qq.com", "否"));
	}

	@Test
	public void testGetUserById() {
		User user = userDao.getUserById(7);
		System.out.println(user);
	}

	@Test
	public void testGetUserByName() {


		User user = userDao.getUserByName("小芳");
		System.out.println(user);
	}

	@Test
	public void testForLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserList() {
		ArrayList<User> arrayList = userDao.getUserList();
		for (User user : arrayList) {
			System.out.println(user);
		}
	}

}
