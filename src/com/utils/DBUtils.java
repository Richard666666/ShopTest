package com.utils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;



public class DBUtils<T> {
	
	//添加、删除、更新
	
	public static int commonUpdate(String sql,Object ...param){
		
		Connection conn = DBManager.getConnection();
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				prepareStatement.setObject((i+1), param[i]);
			}
			return prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, prepareStatement, null);
		}
		return 0;
	}
	//主键回填
	public static int commonInsert(String sql,Object ...param){

		Connection conn = DBManager.getConnection();
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < param.length; i++) {
				prepareStatement.setObject((i+1), param[i]);
			}
			prepareStatement.executeUpdate();
			 
			 //结果集里放着的就是主键
			 ResultSet resultSet = prepareStatement.getGeneratedKeys();
			 if(resultSet.next()){
				return resultSet.getInt(1);
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, prepareStatement, null);
		}
		return 0;
	}

	
	//查询 "select * from user where xxx=?"
	public ArrayList<T> commonQuery(String sql,Class<T> cla,Object ...param){
		
		ArrayList<T> list = new ArrayList<>();
		
		Connection conn = DBManager.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		try {
			prepareStatement = conn.prepareStatement(sql);
			
			if(param != null){
				for (int i = 0; i < param.length; i++) {
					prepareStatement.setObject((i+1), param[i]);
				}
			}
			
			resultSet = prepareStatement.executeQuery();
			
			ResultSetMetaData metaData = resultSet.getMetaData();//存放表信息的对象
			int columnCount = metaData.getColumnCount();//获取字段数量
			
			
			while(resultSet.next()){//判断是否还有一行一行的数据
				
				//利用反射创建对象
				T instance = null;
				try {
					Constructor<T> constructor = cla.getConstructor();//获得构造方法
					instance = constructor.newInstance();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				for (int i = 1; i <= columnCount; i++) {
					String columnName = metaData.getColumnName(i);//字段名 user_name
					Object object = resultSet.getObject(columnName);//字段值 hhy
					
					try {
						Field field = cla.getDeclaredField(columnName);
						field.setAccessible(true);
						field.set(instance, object);
					} catch (NoSuchFieldException e) {
						
						
						Properties properties = new Properties();
						try {
							properties.load(DBUtils.class.getClassLoader().getResourceAsStream("VOConfig.properties"));
							
							String fieldName = properties.getProperty(columnName);
							Field field = cla.getDeclaredField(fieldName);
							field.setAccessible(true);
							field.set(instance, object);
						
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (NoSuchFieldException e1) {
							e1.printStackTrace();
						} catch (SecurityException e1) {
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							e1.printStackTrace();
						}
						
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				list.add(instance);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, prepareStatement, resultSet);
		}
		return list;
	}
}









