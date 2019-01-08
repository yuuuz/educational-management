<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>西安建筑科技大学教务管理系统</title>
<link href="<%=request.getContextPath() %>/layui/css/login.css" rel="stylesheet" type="text/css" />
</head>


<body>
<div class="login_box">
      <div class="login_l_img"><img src="<%=request.getContextPath() %>/image/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="#"><img src="<%=request.getContextPath() %>/image/login_logo.png" /></a></div>
          <div class="login_name">
               <p>教务管理系统</p>
          </div>
          <form method="post">
              <input name="username" type="text"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
              <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
			<input name="password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
              <div class="single_select" >
              	<span><input name="users" type="radio" value="admin" />管理员 </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              	        	
              	<span><input name="users" type="radio" value="teacher" />老师  </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              	<span><input name="users" type="radio" value="student" checked="true" />学生</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              </div>
							<a href="<%request.getContextPath();%>/">
								<input value="登录" style="width:100%;" type="submit">
							</a>
							<div style="color: red">${errorMsg}</div>
          </form>
      </div>
      <div class="copyright">西安建筑科技大学 版权所有©2018-2019 </div>
</div>
</body>
</html>