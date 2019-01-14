<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <!-- 引入layui的样式文件 -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.1.1.min.js"></script>
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
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>老师信息-新增</legend>
</fieldset>
</div>
<div class="layui-row">
<!-- action form提交的地址 -->
<form id="form1" class="layui-form" action="<%=request.getContextPath() %>/teacher/save" method="post">
  <input type="hidden" name="t_id"/>
  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input value="${obj.t_name}" type="text" id="name" name="t_name" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input onblur="isExist(this)">
    </div>
  </div>
  <div class="layui-form-item">
    <button class="layui-btn" type="button" onclick="validate()">保存</button>
    <button class="layui-btn" type="button" onclick="javascript:history.back(-1)">返回</button>
  </div>
</form>
</div>
</div>
<script type="text/javascript">
//验证姓名是否已经存在
function isExist(obj){
	// 姓名
	var name = obj.value;
	url ="<%=request.getContextPath()%>/teacher/isExist";//验证姓名
	$.post(url,{t_name:name},function(data){
		console.log(">>>"+data);
		if(data == "yes"){
			alert("系统已经存在系统姓名的教师信息了")
		}
	});
}
// 验证数据(自己写的js脚本)
function validate(){
	// name的输入框
	var nameObj = document.getElementById("name");
	if(nameObj.value==""){
		alert("姓名不能为空");
		return false;
	}else{
		url ="<%=request.getContextPath()%>/teacher/isExist";//验证姓名
		// 默认为异步，
// 		$.post(url,{name:nameObj.value},function(data){
// 			if(data == "yes"){
// 				alert("系统已经存在系统姓名的教师信息了");
// 				return false;
// 			}
// 		});
		$.ajax({
			   type: "POST",
			   url: url,
			   data: "t_name="+nameObj.value,
			   success: function(data){
		 			if(data == "yes"){
		 				alert("系统已经存在系统姓名的教师信息了");
		 				return false;
		 			}else{
		 				console.log(">>>返回true");
		 				$("#form1").submit();
		 				return true;// 返回true就能提交表单
		 			}
			   },
			   async: false //表示同步方式
			});
	}
}

</script>
</body>
</html>