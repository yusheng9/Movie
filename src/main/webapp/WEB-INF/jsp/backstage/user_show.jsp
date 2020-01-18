<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户查看</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
	<c:if test="${movieUser.userHeadimg=='' || movieUser.userHeadimg==null }">
		<img class="avatar size-XL l" src="${pageContext.request.contextPath }/backstage/static/h-ui/images/ucnter/avatar-default.jpg">
	</c:if>
	<c:if test="${movieUser.userHeadimg!='' && movieUser.userHeadimg!=null }">
		<img class="avatar size-XL l" src="${movieUser.userHeadimg}">
	</c:if>
	<dl style="margin-left:80px; color:#fff">
		<dt>
			<span class="f-18">${movieUser.userName }</span>
			<span class="pl-10 f-12">余额：0</span>
		</dt>
		<c:if test="${movieUser.userIntro=='' || movieUser.userIntro==null }">
			<dd class="pt-10 f-12" style="margin-left:0">这家伙很懒，什么也没有留下</dd>
		</c:if>
		<c:if test="${movieUser.userIntro!='' && movieUser.userIntro!=null }">
			<dd class="pt-10 f-12" style="margin-left:0">${movieUser.userIntro}</dd>
		</c:if>
	</dl>
</div>
<div class="pd-20">
	<table class="table">
		<tbody>
			<tr>
				<th class="text-r" width="80">性别：</th>
				<td>${movieUser.userSex}</td>
			</tr>
			<tr>
				<th class="text-r">手机：</th>
				<td>${movieUser.userPhone}</td>
			</tr>
			<tr>
				<th class="text-r">QQ：</th>
				<td>${movieUser.userQq}</td>
			</tr>
			<tr>
				<th class="text-r">邮箱：</th>
				<td>${movieUser.userEmail}</td>
			</tr>
			<tr>
				<th class="text-r">地址：</th>
				<td>${movieUser.province} ${movieUser.city} ${movieUser.district}</td>
			</tr>
			<tr>
				<th class="text-r">注册时间：</th>
				<td>${movieUser.createTime}</td>
			</tr>
			<tr>
				<th class="text-r">积分：</th>
				<td>0</td>
			</tr>
		</tbody>
	</table>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
</body>
</html>