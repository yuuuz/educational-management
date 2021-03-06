<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引入标签jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <!-- 引入layui的样式文件 -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css">

<title>老师信息的展示</title>
<script>
function query(){
	var name = document.getElementById("name").value;
	var id = document.getElementById("id").value;
	document.location.href="<%=request.getContextPath()%>/teacher/list?pageNum=1&pageSize=5&q_name="+name+"&q_id="+id;
}
</script>
<% 
    if(session.getAttribute("loginUser")== null){
         response.sendRedirect("login");
         return;
    }
%>
</head>
<body>
<div class="layui-container"> 
<div class="layui-row">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>教师信息</legend>
</fieldset>
</div>
<div class="layui-row">
<table>
<tr>
	<td>职工号：<input id="id" name="q_id" value="${t_id}"/></td>
	<td>姓名：<input id="name" name="q_name" value="${t_name}"/></td>
	<td><button class="layui-but" onclick="query()">查询</button></td></tr>
</table>
<!--增加一个新增按钮 -->
<a href="<%=request.getContextPath() %>/teacher/add.jsp" class="layui-btn layui-btn-sm">新增</a>
<!-- 用table -->
<table class="layui-table">
	<thead><tr><th>序号</th><th>职工号</th><th>姓名</th><th width="200px">操作</th></tr></thead>
	<tbody>
	<!-- 如何展示集合对象   使用标签c:forEach  items 集合对象的名字-->
	<c:forEach items="${pageInfo.list}" var="t" varStatus="st">
	<tr>
		<td>${st.count}</td>
		<td>${t.t_id}</td>
		<td>${t.t_name}</td>
		<td><div class="layui-btn-group">
    <button class="layui-btn" onclick="javascript:document.location.href='<%=request.getContextPath()%>/teacher/view?t_id=${t.t_id}';">查看</button>
    <button class="layui-btn" onclick="javascript:document.location.href='<%=request.getContextPath()%>/teacher/edit?t_id=${t.t_id}';">编辑</button>
    <button class="layui-btn" onclick="javascript:if(confirm('确定要删除么'))document.location.href='<%=request.getContextPath()%>/teacher/delete?t_id=${t.t_id}';">删除</button>
  </div></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<div id="test1"></div>
</div>
</div>
<script src="<%=request.getContextPath() %>/layui/layui.js"></script>
<script type="text/javascript">
	var msg ="${msg}";
	if(msg!=""){
		alert(msg);
	}
	// 使用laypage
	layui.use('laypage', function(){
		  var laypage = layui.laypage;
		  
		  //执行一个laypage实例
		  laypage.render({
		    elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
		    ,count: '${pageInfo.total}' //数据总数，从服务端得到
		    ,limit: '${pageInfo.pageSize}'// 每页显示的最大记录数
		    ,curr: '${pageInfo.pageNum}' // 指明当前页
		    ,jump: function(obj, first){
		        //obj包含了当前分页的所有参数，比如：
		        console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
		        console.log(obj.limit); //得到每页显示的条数
		       
		        //首次不执行
		        if(!first){
		        	// 改变当前的地址
		        	var id = document.getElementById("id").value;
		        	var name = document.getElementById("name").value;
		        	var url = "<%=request.getContextPath()%>/teacher/list?pageNum=" +obj.curr+"&pageSize="+obj.limit+"&q_name="+name+"&q_id="+id;
		        	console.log(url);
		        	document.location.href=url;
		        }
		      }
		  });
		});
</script>
</body>
</html>










