<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <!-- 引入layui的样式文件 -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css">
<title>已选课程</title>
</head>
<body>
<div class="layui-container"> 
<div class="layui-row">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>已选课程信息</legend>
</fieldset>
</div>
<div class="layui-row">

<!-- 用table -->
<table class="layui-table">
	<thead><tr><th>课程编号</th><th>课程名称</th><th>代课老师</th><th>学分</th><th>学时</th><th>课程类型</th><th>操作</th></tr></thead>
	<tbody>
	<!-- 如何展示集合对象   使用标签c:forEach  items 集合对象的名字-->
	<c:forEach items="${pageInfo.list}" var="t">
	<tr>
		<td>${t.co_id}</td>
		<td>${t.co_name}</td>
		<td>${t.t_name}</td>
		<td>${t.co_credit}</td>
		<td>${t.co_period}</td>
		<td>${t.co_type}</td>
		<td><button class="layui-btn" onclick="javascript:if(confirm('确定要退选么'))document.location.href='<%=request.getContextPath()%>/course/drop?s_c_id=${t.s_c_id}';">退选</button></td>
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
		        	var url = "<%=request.getContextPath()%>/course/selectedlist?pageNum=" +obj.curr+"&pageSize="+obj.limit +"&s_id="+ ${loginUser.s_id};
		        	console.log(url);
		        	document.location.href=url;
		        }
		      }
		  });
		});
</script>
</body>
</html>