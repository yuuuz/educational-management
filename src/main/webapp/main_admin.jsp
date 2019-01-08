<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>后台管理-教务管理系统</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css">
  <style>
		body{background-image:url('image/bg.jpg');
			background-repeat:no-repeat;
			background-attachment:fixed;
			background-size:cover
			}
	</style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">教务管理系统</div>
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
         ${sessionScope.loginUser.m_name}
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
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:go('teacher/list');">教师管理</a></dd>
            <dd><a href="javascript:go('student/list');">学生管理</a></dd>
            <dd><a href="javascript:;">课程管理</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">解决方案</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="">云市场</a></li>
        <li class="layui-nav-item"><a href="">发布商品</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <iframe onload="resetFrame()" id="main" style="border:0;width:100%;"></iframe>
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






