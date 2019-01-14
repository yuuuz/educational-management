<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- 引入layui的样式文件 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/layui/css/layui.css">

<title>老师信息的展示</title>
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
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 30px;">
				<legend>老师信息-详情</legend>
			</fieldset>
		</div>
		<div class="layui-row">
			<form class="layui-form" action="">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">姓名</label>
						<div class="layui-input-inline">
							<input type="text" name="name" value="${obj.t_name}" readonly
								lay-verify="title" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">性别</label>
						<div class="layui-input-inline">
							<input type="text" name="name" value="${obj.t_sex}" readonly
								lay-verify="title" class="layui-input">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<button class="layui-btn" type="button"
						onclick="javascript:history.back(-1)">返回</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>