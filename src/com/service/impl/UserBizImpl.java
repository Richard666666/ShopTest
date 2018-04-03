package com.service.impl;

import java.util.ArrayList;

import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;
import com.service.IUserBiz;
import com.vo.User;

public class UserBizImpl implements IUserBiz {
        IUserDao userDao=new UserDaoImpl();
	@Override
	public int add(User user) {
		User u = userDao.getUserByName(user.getName());
		if(u==null) {
		return userDao.add(user);
		}
		return 0;
	}

	@Override
	public int delete(Integer id) {
		
		return userDao.delete(id);
	}

	@Override
	public int update(User user) {
		
		return userDao.update(user);
	}

	@Override
	public User getUserById(Integer id) {
		
		return userDao.getUserById(id);
	}

	@Override
	public User getUserByName(String name) {
		
		return userDao.getUserByName(name);
	}

	@Override
	public User forLogin(String name, String password) {
		
		return userDao.forLogin(name, password);
	}

	@Override
	public ArrayList<User> getUserList() {
		// TODO Auto-generated method stub
		return userDao.getUserList();
	}

}
