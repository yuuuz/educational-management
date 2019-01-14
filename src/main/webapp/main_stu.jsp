<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>后台管理-学生管理系统</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css">
</head>
<% 
    if(session.getAttribute("loginUser")== null){
         response.sendRedirect("login");
         return;
    }
%>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">教务管理系统-学生端</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
<!--       <li class="layui-nav-item"><a href="">控制台</a></li> -->
<!--       <li class="layui-nav-item"><a href="">商品管理</a></li> -->
<!--       <li class="layui-nav-item"><a href="">用户</a></li> -->
<!--       <li class="layui-nav-item"> -->
<!--         <a href="javascript:;">其它系统</a> -->
<!--         <dl class="layui-nav-child"> -->
<!--           <dd><a href="">邮件管理</a></dd> -->
<!--           <dd><a href="">消息管理</a></dd> -->
<!--           <dd><a href="">授权管理</a></dd> -->
<!--         </dl> -->
<!--       </li> -->
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
         ${sessionScope.loginUser.s_name}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="<%=request.getContextPath()%>/logout">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed"><a href="javascript:go('my/queryScore')">成绩查询</a></li>
        <li class="layui-nav-item"><a href="javascript:go('my/editInfo')">个人信息</a></li>
        <li class="layui-nav-item"><a href="javascript:go('student/resetPassword?s_id=${loginUser.s_id}')">修改密码</a></li>
        <li class="layui-nav-item"><a href="javascript:go('notice/list')">通知公告</a></li>
        <li class="layui-nav-item">
          <a href="javascript:;">课程管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:go('course/prelist?s_id=${loginUser.s_id}')">选课</a></dd>
            <dd><a href="javascript:go('course/selectedlist?s_id=${loginUser.s_id}')">已选课程</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    
    <iframe onload="resetFrame()" src="notice/list" id="main" style="border:0;width:100%;">
    </iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
   版权所有 © 西安建筑科技大学  计算机1501
  </div>
</div>
<script src="<%=request.getContextPath() %>/layui/layui.js"></script>
<script>
function go(url){
	//在iframe打开该地址
	// 获取iframe
	var obj = document.getElementById("main");
	// 通过设置src
	obj.src="<%=request.getContextPath()%>/"+url;
	
}
function resetFrame(){
	var h =document.documentElement.scrollHeight|| document.body.scrollHeight;
	var obj = document.getElementById("main");
	console.log(">>>"+h);
	obj.height=(h-60-44-2)+"px";
}
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>






