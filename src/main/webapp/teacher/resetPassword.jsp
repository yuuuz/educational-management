<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css">
<title>修改密码</title>
</head>
<body>
<div class="layui-container"> 
<div class="layui-row">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>修改个人密码</legend>
</fieldset>
</div>
<div class="layui-row" >
<form class="layui-form" action="<%=request.getContextPath() %>/teacher/savePassword?t_id=${loginUser.t_id}" method="post">
  <div class="layui-form-item">
	<label class="layui-form-label">用户</label>
	<div class="layui-input-inline">
		<input type="text" name="name" value="${loginUser.t_id}" readonly lay-verify="title" class="layui-input">
	</div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">旧密码</label>
    <div class="layui-input-inline">
      <input type="password" name="oldPassword" required="required" lay-verify="title" autocomplete="off" placeholder="请输入旧密码" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">新密码</label>
    <div class="layui-input-inline">
      <input type="password" name="newPassword" required="required" lay-verify="title" placeholder="请输入新密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">确认密码</label>
    <div class="layui-input-inline">
      <input type="password" name="confirmNewPassword" required="required" lay-verify="title" placeholder="请确认新密码" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button class="layui-btn" type="submit">确定</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button class="layui-btn" type="button" onclick="javascript:history.back(-1)">取消</button>
  </div>
</form>
</div>
</div>
<script type="text/javascript">
var msg ="${msg}";
if(msg!=""){
	alert(msg);
}
</script>
</body>
</html>