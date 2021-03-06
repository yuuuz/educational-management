<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <!-- 引入layui的样式文件 -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css">

<title>学生信息的展示</title>
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
  <legend>学生信息-编辑</legend>
</fieldset>
</div>
<div class="layui-row">
<form class="layui-form" action="<%=request.getContextPath() %>/student/save" method="post">
  <input type="hidden" name="s_id" value="${obj.s_id}"/>
  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input value="${obj.s_name}" type="text" id="name" name="s_name" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
     <button class="layui-btn" type="submit" onclick="return validate();">保存</button>
    <button class="layui-btn" type="button" onclick="javascript:history.back(-1)">返回</button>
  </div>
</form>
</div>
</div>
<script type="text/javascript">
//验证数据(自己写的js脚本)
function validate(){
	// name的输入框
	var nameObj = document.getElementById("name");
	if(nameObj.value==""){
		alert("姓名不能为空");
		return false;
	}
	return true;// 返回true就能提交表单
}
</script>
</body>
</html>







