<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<a href="${page.url}1">首页</a>
	
	<c:if test="${page.currentPage>1}">
		<a href="${page.url}${page.currentPage-1}">上一页</a>
	</c:if>
	
	<span>第${page.currentPage}页</span>
	
	<c:if test="${page.currentPage<page.allPage}">
		<a href="${page.url}${page.currentPage+1}">下一页</a>
	</c:if>
	<a href="${page.url}${page.allPage}">尾页</a>