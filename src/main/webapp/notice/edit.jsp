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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
<title>编辑公告</title>
</head>
<body>
	<div class="layui-container">
		<div class="layui-row">
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 30px;">
				<legend>编辑公告内容</legend>
			</fieldset>
		</div>
		<div class="layui-row">
			<form id="form1" class="layui-form" action="<%=request.getContextPath()%>/notice/save" method="post">
				<input type="hidden" name="no_id" value="${obj.no_id}" />
				<div class="layui-form-item">
					<label class="layui-form-label">标题</label>
					<div class="layui-input-block">
      					<input value="${obj.title}" required="required" type="text" id="title" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
    				</div>
				</div>
				<div class="layui-form-item layui-form-text">
    				<label class="layui-form-label">内容</label>
    				<div class="layui-input-block">
      					<textarea wrap="hard" rows="20" cols="100" required="required" id="context" placeholder="请输入内容" class="layui-textarea" name="context">${obj.context}</textarea>
    				</div>
  				</div>
  				<div class="layui-form-item">
    				<button class="layui-btn" type="submit">保存</button>
    				<button class="layui-btn" type="button" onclick="javascript:history.back(-1)">返回</button>
  				</div>
			</form>
		</div>
	</div>
</body>
</html>