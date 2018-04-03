package com.dao.impl;

import java.util.ArrayList;

import com.dao.IUserDao;
import com.utils.DBUtils;
import com.vo.User;

public class UserDaoImpl implements IUserDao {
	DBUtils<User> dbUtils = new DBUtils<>();

	@Override
	public int add(User user) {
		String sql = "insert into t_user(name,password,sex,phone,email,is_admin) values(?,?,?,?,?,?)";
		return DBUtils.commonUpdate(sql, user.getName(), user.getPassword(), user.getSex(), user.getPhone(),
				user.getEmail(), user.getIsAdmin());
	}

	@Override
	public int delete(Integer id) {

		String sql = "delete from t_user where id=?";
		return DBUtils.commonUpdate(sql, id);
	}

	@Override
	public int update(User user) {
		String sql = "update t_user set name=?,password=?,sex=?,phone=?,email=?,is_admin=? where id=? ";
		return DBUtils.commonUpdate(sql, user.getName(), user.getPassword(), user.getSex(), user.getPhone(),
				user.getEmail(), user.getIsAdmin(), user.getId());
	}

	@Override
	public User getUserById(Integer id) {

		String sql = "select * from t_user where id=?";
		ArrayList<User> arrayList = dbUtils.commonQuery(sql, User.class, id);
		if (!arrayList.isEmpty()) {
			return arrayList.get(0);
		}
		return null;
	}

	@Override
	public User getUserByName(String name) {
		String sql = "select * from t_user where name=?";
		ArrayList<User> arrayList = dbUtils.commonQuery(sql, User.class, name);
		if (!arrayList.isEmpty()) {
			return arrayList.get(0);
		}
		return null;
	}

	@Override
	public User forLogin(String name, String password) {
		String sql = "select * from t_user where name=? and password=?";
		ArrayList<User> arrayList = dbUtils.commonQuery(sql, User.class, name, password);
		if (!arrayList.isEmpty()) {
			return arrayList.get(0);
		}
		return null;

	}

	@Override
	public ArrayList<User> getUserList() {
		String sql = "select * from t_user";
		return dbUtils.commonQuery(sql, User.class);
	}

}
