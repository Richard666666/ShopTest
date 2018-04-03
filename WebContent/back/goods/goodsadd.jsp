<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>添加商品信息</span></div>
    <form action="GoodsInfoServlet?action=add" method="post" enctype="multipart/form-data">
    	<ul class="forminfo">
	    <li><label>商品名称</label><input name="goodsName" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
	    <li><label>所属大类</label>
	   
	    		<select name="goodsParentid">
	    		
	    			<option value="0">无</option>
	    		  <c:forEach items="${goodsTypeList}" var="goodsType" >
  					<c:if test="${goodsType.goodsTypeParentId==0}">
  					<option value="${goodsType.id}"> ${goodsType.goodsTypeName}</option>
  					</c:if>
  					 </c:forEach>	
	    		</select>
	  	
	    </li>
	    <li><label>所属小类</label>
	    		<select name="goodsFatherid">
	    		<option value="0">无</option>
	    		 <c:forEach items="${goodsTypeList}" var="goodsType" >
  					<c:if test="${goodsType.goodsTypeParentId!=0}">
  					<option value="${goodsType.id}"> ${goodsType.goodsTypeName}</option>
  					</c:if>
  					 </c:forEach>	
	    		</select>
	    </li>
	     <li><label>商品库存</label><input name="goodsStock" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
	     <li><label>商品原价</label><input name="goodsPrice" type="text" class="dfinput" /></li>
	     <li><label>商品现价</label><input name="goodsPriceOff" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
	     <li><label>商品折扣</label><input name="goodsDiscount" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
	     <li><label>商品图片</label><input name="goodsPic" type="file" /></li>
	    <li><label>商品描述</label><textarea rows="8" cols="40" name="goodsDescription" ></textarea></li>
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    
    </form>
    </div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

