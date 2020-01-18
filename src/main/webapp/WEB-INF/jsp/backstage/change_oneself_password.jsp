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
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>修改密码 - 会员管理 </title>
<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
		<form action="${pageContext.request.contextPath }/admin/updatePassword/${movieAdminUser.auserId }" method="post" class="form form-horizontal" id="form-change-password">
			<c:if test="${movieAdminUser.auserName==adminUser.auserName }">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>原密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" autocomplete="off" placeholder="不修改请留空" name="rawpassword" id="rawpassword">
				</div>
			</div>
			</c:if>
			<c:if test="${movieAdminUser.auserName!=adminUser.auserName }">
				<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>账户：</label>
				<div class="formControls col-xs-8 col-sm-9"> ${movieAdminUser.auserName } </div>
				<input type="hidden" name="rawpassword">
			</div>
			</c:if>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" autocomplete="off" placeholder="不修改请留空" name="password" id="newpassword">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" autocomplete="off" placeholder="不修改请留空" name="newpassword2" id="new-password2">
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;保存&nbsp;&nbsp;">
				</div>
			</div>
		</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(function(){
	$("#form-change-password").validate({
		rules:{
			rawpassword:{
				required:true,
				minlength:5,
				maxlength:16
			},
			password:{
				required:true,
				minlength:5,
				maxlength:16
			},
			newpassword2:{
				required:true,
				minlength:5,
				maxlength:16,
				equalTo: "#newpassword"
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				dataType: "json",
				success: function(data){
					console.log(data);
					if(data==1){
						layer.alert('修改成功，请重新登录！',{
							 skin: 'layui-layer-molv' //样式类名  自定义样式
	                            ,closeBtn: 1    // 是否显示关闭按钮
	                            ,anim: 1 //动画类型
	                            ,btn: ['关闭'] //按钮
	                            ,icon: 6    // icon
	                            ,yes:function(){
	                            	window.open("${pageContext.request.contextPath }/admin/alogin","_top");
	                            }
						});
						/* layer.msg('修改成功，请重新登录！',{icon:1,time:1000});
						setTimeout(function(){
							//window.location.href="${pageContext.request.contextPath }/admin/alogin";
							window.open("${pageContext.request.contextPath }/admin/alogin","_top");
					    },1000); */
					}else{
						layer.alert('原密码不正确!',{
							 skin: 'layui-layer-molv' //样式类名  自定义样式
	                            ,closeBtn: 1    // 是否显示关闭按钮
	                            ,anim: 1 //动画类型
	                            ,btn: ['关闭'] //按钮
	                            ,icon: 5    // icon
	                            
						});
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