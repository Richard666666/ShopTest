package com.service;

import java.util.ArrayList;

import com.vo.User;

public interface IUserBiz {

	/**
	 * 添加用户
	 * @param user 用户对象
	 * @return 影响数据的行数
	 */
       public int add(User user);
       /**
        * 删除用户
        * @param id 用户的id
        * @return 影响数据的行数
        */
       
       public int delete(Integer id);
       /**
        * 修改用户
        * @param user 用户对象
        * @return   影响数据的行数
        */
       
       public  int update(User user);
       /**
        * 通过id查询用户
        * @param id 用户id
        * @return 用户对象
        */
       public User getUserById(Integer id);
       /**
        * 通过name查找用户
        * @param name 用户名
        * @return 用户对象
        */
       
       public User getUserByName(String name);
       
       /**
        * 通过name和id找对象
        * @param id
        * @param name
        * @return  用户对象
        */
       
       public User forLogin(String name,String password);
       
       /**
        *  获取集合
        * @return 用户集合
        */
       public ArrayList<User> getUserList();
       
       
       
}
