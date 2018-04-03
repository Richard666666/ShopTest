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
<script type="text/javascript">

      function loadimg(obj){
    	  
    	 var file= obj.files[0];//获取上传文件组件里的文件对象
          var url= window.URL.createObjectURL(file);//创建文件对象的URL地址
    	  document.getElementById("img").src=url;//创建文件对象的URL地址
    	  
      }
</script>



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
    
    <div class="formtitle"><span>修改商品信息</span></div>
    <form action="GoodsInfoServlet?action=update" method="post" enctype="multipart/form-data">
    	<input type="hidden" name="id" value="${goodsInfo.id}"/>
    	<ul class="forminfo">
	    <li><label>商品名称</label><input name="goodsName" value="${goodsInfo.goodsName}"  type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
	    <li><label>所属大类</label>
	    		<select name="goodsParentid">
	    		<option value="0" >无</option>
	    		<c:forEach items="${goodsTypeList}" var="goodsType"> 
	    		<c:if test="${goodsType.goodsTypeParentId == 0}">
	    		 <c:choose>		
	    			<c:when test="${goodsInfo.goodsParentid == goodsType.id }"> 			
	    			 <option value="${goodsType.id }" selected="selected">${goodsType.goodsTypeName}</option>
	    			</c:when>
	    			<c:otherwise>
	    			<option value="${goodsType.id}" >${goodsType.goodsTypeName}</option>
	    			</c:otherwise>
    			</c:choose> 
    			</c:if>	   
    			  </c:forEach>
	    		</select>
	    		
	    </i></li>
	  <li><label>所属小类</label>
	    	<select name="goodsFatherid">
	    		<option value="0">无</option>
	    		<c:forEach items="${goodsTypeList}" var="goodsType"> 
	    		<c:if test="${goodsType.goodsTypeParentId !=0}">
	    		 <c:choose>		
	    			<c:when test="${goodsInfo.goodsFatherid == goodsType.id }"> 			
	    			 <option value="${goodsType.id }" selected="selected">${goodsType.goodsTypeName}</option>
	    			</c:when>
	    			<c:otherwise>
	    			<option value="${goodsType.id}" >${goodsType.goodsTypeName}</option>
	    			</c:otherwise>
    			</c:choose> 
    			</c:if>	   
    			  </c:forEach>
	    
	    	</select>
	     </i></li>    
	     	
	   
	    <li><label>商品库存</label><input name="goodsStock" type="text" class="dfinput" value="${goodsInfo.goodsStock}"/><i>标题不能超过30个字符</i></li>
	     <li><label>商品原价</label><input name="goodsPrice" type="text" class="dfinput" value="${goodsInfo.goodsPrice}"/></li>
	     <li><label>商品现价</label><input name="goodsPriceOff" type="text" class="dfinput" value="${goodsInfo.goodsPriceOff}"/><i>标题不能超过30个字符</i></li>
	     <li><label>商品折扣</label><input name="goodsDiscount" type="text" class="dfinput" value="${goodsInfo.goodsDiscount}"/><i>标题不能超过30个字符</i></li>
	     <li><label>商品图片</label>
	     	<img id="img" src="images/${goodsInfo.goodsPic}" width="100px" height="100px" />
	     	<input name="goodsPic" type="file" onchange="loadimg(this)" />
	     </li>
	     <li><label>商品描述</label><textarea rows="8" cols="40" name="goodsDescription">${goodsInfo.goodsDescription}</textarea><i>标题不能超过30个字符</i></li>
	   
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    
    </form>
    </div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

