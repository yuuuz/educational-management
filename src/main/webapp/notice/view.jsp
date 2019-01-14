<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- 引入layui的样式文件 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/layui/css/layui.css">
<title>通知公告</title>
</head>
<% 
    if(session.getAttribute("loginUser")== null){
         response.sendRedirect("login");
         return;
    }
%>
<body>
	<div class="layui-container"> 
		<div class="layui-row">
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  			<legend>通知公告</legend>
		</fieldset>
		</div>
		<h2 style="text-align: center;"><b>${obj.title}</b></h2>
		<pre>${obj.context}</pre>
	</div>	
</body>
</html>