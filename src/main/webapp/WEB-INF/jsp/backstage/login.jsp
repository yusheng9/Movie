<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="${pageContext.request.contextPath }/backstage/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/backstage/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/backstage/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/backstage/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>后台登录 - H-ui.admin v3.1</title>
<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header">后台管理系统</div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="auserName" name="auserName" type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="userPassword" name="userPassword" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input id="code" class="input-text size-L" name="code" type="text" placeholder="验证码" style="width:150px;">
          <img src="${pageContext.request.contextPath }/user/checkCode" alt="" width="100" height="32" class="passcode"
										style="height: 41px;width:120px; cursor: pointer;"
										onclick="this.src=this.src+'?'" title="点击切换验证码"></div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input type="button" id="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright </div>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/layer/2.4/layer.js"></script>

<script type="text/javascript">

	$(function() {
		$("#button").click(function() {
			var name=$("#auserName").val();
			var pwd=$("#userPassword").val();
			var code=$("#code").val();
			if(name==''){
				layer.msg('请输入用户名!',{icon: 5,time:1000});
			}else if(pwd==''){
				layer.msg('请输入密码!',{icon: 5,time:1000});
			}else if(code==''){
				layer.msg('请输入验证码!',{icon: 5,time:1000});
			}else{
				$.ajax({
					type: "GET",//传输方式
					url: "${pageContext.request.contextPath }/admin/adminLogin",//提交URL
					data: {	"auserName": name,
							"userPassword":pwd,
							"code":code},//提交的数据
					dataType: "json",
					success: function(data) {
						console.log(data);
			        	if(name!='' && pwd!='' && code!=''){
			        		if(data==2){
				        		alert("用户名或密码错误");
							}else if(data==1){
								alert("验证码错误");
							}else{
								location.href="${pageContext.request.contextPath }/admin/index";
							}
						}
					}
		    	});
			}
		});
		$(document).keyup(function(event){
		  if(event.keyCode ==13){
		    $("#button").trigger("click");
		  }
		});
	});
</script>
</body>
</html>