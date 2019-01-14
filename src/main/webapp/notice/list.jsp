<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引入标签jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <!-- 引入layui的样式文件 -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css">

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
<div class="layui-row">
<table class="layui-table">
	<tbody>
	<!-- 如何展示集合对象   使用标签c:forEach  items 集合对象的名字-->
	<c:forEach items="${pageInfo.list}" var="t">
	<tr>
		<td><a href="<%=request.getContextPath()%>/notice/view?no_id=${t.no_id}">${t.title}</a></td>
		<td><fmt:formatDate value="${t.date}" pattern="yyyy年MM月dd日 HH:mm:ss" /> </td>
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
		    ,count: '${pageInfo.total}'  //数据总数，从服务端得到
		    ,limit: '${pageInfo.pageSize}' // 每页显示的最大记录数
		    ,curr: '${pageInfo.pageNum}' // 指明当前页
		    ,jump: function(obj, first){
		        //obj包含了当前分页的所有参数，比如：
		        console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
		        console.log(obj.limit); //得到每页显示的条数
		       
		        //首次不执行
		        if(!first){
		        	// 改变当前的地址
		        	var url = "<%=request.getContextPath()%>/notice/list?pageNum=" +obj.curr+"&pageSize="+obj.limit;
		        	console.log(url);
		        	document.location.href=url;
		        }
		      }
		  });
		});
</script>
</body>
</html>

