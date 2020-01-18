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
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/static/h-ui.admin/css/style.css" />

<link rel="stylesheet" type="text/css" href="/Level/css/main.css" />
<link rel="stylesheet" type="text/css" href="/Level/css/normalize.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>添加用户 - H-ui.admin v3.1</title>
<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<input type="hidden" value="${movieUser.userId }" name="userId">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${movieUser.userName }" placeholder="" id="username" name="userName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<c:if test="${movieUser.userSex=='男' }">
					<div class="radio-box">
						<input name="userSex" type="radio" id="sex-1" value="男" checked>
						<label for="sex-1">男</label>
					</div>
					<div class="radio-box">
						<input name="userSex" type="radio" id="sex-2" value="女">
						<label for="sex-2">女</label>
					</div>
					<div class="radio-box">
						<input name="userSex" type="radio" id="sex-3" value="保密">
						<label for="sex-3">保密</label>
					</div>
				</c:if>
				<c:if test="${movieUser.userSex=='女' }">
					<div class="radio-box">
						<input name="userSex" type="radio" id="sex-1" value="男">
						<label for="sex-1">男</label>
					</div>
					<div class="radio-box">
						<input name="userSex" type="radio" id="sex-2" value="女" checked>
						<label for="sex-2">女</label>
					</div>
					<div class="radio-box">
						<input name="userSex" type="radio" id="sex-3" value="保密">
						<label for="sex-3">保密</label>
					</div>
				</c:if>
				<c:if test="${movieUser.userSex=='保密' }">
					<div class="radio-box">
						<input name="userSex" type="radio" id="sex-1" value="男">
						<label for="sex-1">男</label>
					</div>
					<div class="radio-box">
						<input name="userSex" type="radio" id="sex-2" value="女">
						<label for="sex-2">女</label>
					</div>
					<div class="radio-box">
						<input name="userSex" type="radio" id="sex-3" value="保密" checked>
						<label for="sex-3">保密</label>
					</div>
				</c:if>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${movieUser.userPhone }" placeholder="" id="mobile" name="userPhone">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${movieUser.userEmail }" placeholder="@" name="userEmail" id="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">所在城市：</label>
			<div id="distpicker5">
				<div class="form-group" style="float: left;margin-left: 15px;">
					<select data-province="${movieUser.province }" class="input-text" id="province5" name="province" style=""></select>
				</div>
				<div class="form-group" style="float: left;margin-left: 15px;">
					<select data-city="${movieUser.city }" class="input-text"  id="city5" name="city" style=""></select>
				</div>
				<div class="form-group" style="float: left;margin-left: 15px;">
					<select data-district="${movieUser.district }" class="input-text" id="district5" name="district" style=""></select>
				</div>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<!-- 中国省市区地址三级联动jQuery插件 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/frontdesk/js/distpicker.data.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/frontdesk/js/distpicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/frontdesk/js/main.js"></script>
<script type="text/javascript">
$(function(){

	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").validate({
		rules:{
			userName:{
				required:true,
				minlength:2,
				maxlength:16
			},
			userSex:{
				required:true,
			},
			userPhone:{
				required:true,
				isMobile:true,
			},
			userPassword:{
				required:true,
			},
			password2:{
				required:true,
				equalTo: "#password"
			},
			userEmail:{
				required:true,
				email:true,
			},
			uploadfile:{
				required:true,
			},
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "${pageContext.request.contextPath }/user/updateUser",
				success: function(data){
					console.log(data);
					if(data>0){
						layer.msg('成功!',{icon:1,time:1000});
						parent.location.reload();
						setTimeout(function(){
							var index = parent.layer.getFrameIndex(window.name);
							parent.$('.btn-refresh').click();
							parent.layer.close(index);
					    },2000);
	
					}
				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('error!',{icon:1,time:1000});
				}
			});
			
		}
	});
});
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>