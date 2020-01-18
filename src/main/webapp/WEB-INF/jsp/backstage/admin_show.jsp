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
<div class="pd-20">
	<table class="table table1">
		<tbody>
			<tr>
				<th class="text-r" width="80">用户名：</th>
				<td>${mau.auserName }</td>
			</tr>
			<tr>
				<th class="text-r" width="80">性别：</th>
				<td>${mau.auserSex }</td>
			</tr>
			<tr>
				<th class="text-r">手机：</th>
				<td>${mau.auserPhone}</td>
			</tr>
			<tr>
				<th class="text-r">邮箱：</th>
				<td>${mau.auserEmail}</td>
			</tr>
			<tr><td style="text-align: right;"><div style="margin-top: 30px;"><input type="button" id="edit" value="编辑" class="btn btn-secondary-outline radius"></div></td></tr>
		</tbody>
		
	</table>
	<form action="" method="" id="form-admin-add">
	<input type="hidden" value="${mau.auserId }" name="auserId" id="auserId">
	<input type="hidden" value="${mau.auserName }" name="auserName">
	<input type="hidden" value="${mau.movieRole.roleId }" name="movieRole.roleId">
		<table class="table table2" style="display: none;">
			<tbody>
				<tr>
					<th class="text-r" width="80">用户名：</th>
					<td>${mau.auserName }</td>
				</tr>
				<tr>
					<th class="text-r" width="80">性别：</th>
					<td>
						<c:if test="${mau.auserSex=='男' }">
							<div class="radio-box">
							    <input type="radio" id="radio-1" name="auserSex" value="男" checked>
							    <label for="radio-1">男</label>
							</div>
							<div class="radio-box">
							    <input type="radio" id="radio-2" name="auserSex" value="女">
							    <label for="radio-2">女</label>
							</div>
						</c:if>
						<c:if test="${mau.auserSex=='女' }">
							<div class="radio-box">
							    <input type="radio" id="radio-1" name="auserSex" value="男">
							    <label for="radio-1">男</label>
							</div>
							<div class="radio-box">
							    <input type="radio" id="radio-2" name="auserSex" value="女" checked>
							    <label for="radio-2">女</label>
							</div>
						</c:if>
					</td>
				</tr>
				<tr>
					<th class="text-r">手机：</th>
					<td><input type="text" value="${mau.auserPhone}" name="auserPhone" class="input-text radius"></td>
				</tr>
				<tr>
					<th class="text-r">邮箱：</th>
					<td><input type="text" value="${mau.auserEmail}" name="auserEmail" class="input-text radius"></td>
				</tr>
				<tr><th></th><td style="text-align: right;"><div style="margin-top: 30px;float: left; width: 200px;"><input type="button" style="float: left;" id="back" value="返回" class="btn btn-warning radius"> <input type="submit" style="float: left;margin-left:10px;" value="保存" class="	btn btn-success radius"></div></td></tr>
			</tbody>
		</table>
	</form>
	
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery.validation/1.14.0/messages_zh.js"></script>

<script type="text/javascript">
	$(function(){
		$('.radio-box input').iCheck({
			checkboxClass: 'icheckbox-blue',
			radioClass: 'iradio-blue',
			increaseArea: '10%'
		});
		
		$("#edit").click(function() {
			$(".table1").css("display","none")
			$(".table2").css("display","block")
		});
		
		$("#back").click(function() {
			$(".table1").css("display","block")
			$(".table2").css("display","none")
		});
		
		$("#form-admin-add").validate({
			rules:{
				auserName:{
					required:true,
					minlength:5,
					maxlength:16
				},
				auserSex:{
					required:true,
				},
				auserPhone:{
					required:true,
					isMobile:true,
				},
				auserEmail:{
					required:true,
					email:true,
				},
			},
			onkeyup:false,
			focusCleanup:true,
			success:"valid",
			submitHandler:function(form){
				$(form).ajaxSubmit({
					type: 'post',
					url: "${pageContext.request.contextPath }/admin/updateAdmin",
					success: function(data){
						console.log(data);
						if(data>0){
							layer.msg('成功!',{icon:1,time:1000});
							location.reload();
							//window.location.href = "${pageContext.request.contextPath }/admin/adminshow/"+$("#auserId")+"";
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
</body>
</html>