package com.utils;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.vo.KeyOption;

public class KeyOptionUtils {

	//获取一次性钥匙对象
	public static KeyOption getKeyOption(HttpServletRequest request){
		KeyOption keyOption = (KeyOption) request.getSession().getAttribute("keyOption");
		if(keyOption == null){
			keyOption = new KeyOption();
		}
		return keyOption;
	}
	
	//创建钥匙
	public static String createKey(){
		return System.currentTimeMillis()+"";
	}
	
	//添加钥匙
	public static void addKey(HttpServletRequest request,String key){
		KeyOption keyOption = getKeyOption(request);
		keyOption.getKeyList().add(key);
		request.getSession().setAttribute("keyOption", keyOption);
	}
	
	//删除钥匙
	public static void deleteKey(HttpServletRequest request,String key){
		
		KeyOption keyOption = getKeyOption(request);
		ArrayList<String> keyList = keyOption.getKeyList();
		Iterator<String> it = keyList.iterator();
		while (it.hasNext()) {
			String string = (String) it.next();
			if(string.equals(key)){
				it.remove();
				break;
			}
		}
		request.getSession().setAttribute("keyOption", keyOption);
	}

	public static boolean isExist(HttpServletRequest request, String key) {
		
		KeyOption keyOption = getKeyOption(request);
		ArrayList<String> keyList = keyOption.getKeyList();
		for (String string : keyList) {
			if(string.equals(key)){
				return true;
			}
		}
		return false;
	}

	
	
	
	
}
