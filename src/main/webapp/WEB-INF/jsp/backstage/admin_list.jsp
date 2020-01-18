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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/css/lc_switch.css" />
<style type="text/css">
	table.dataTable thead .sorting_asc{background-image: none;}
	.dataTables_wrapper .dataTables_filter,.dataTables_wrapper .dataTables_length{display: none;}
</style>
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 管理员列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" name="createTime" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" name="createTime2" style="width:120px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入会员名称、电话、邮箱" id="user" name="user">
		<button type="submit" class="btn btn-success radius" id="button" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="batchDel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a href="javascript:;" onclick="member_add('添加管理员','${pageContext.request.contextPath }/admin/adminadd','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加管理员</a></span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">ID</th>
				<th width="100">用户名</th>
				<th width="40">性别</th>
				<th width="90">手机</th>
				<th width="150">邮箱</th>
				<th width="130">角色</th>
				<th width="130">加入时间</th>
				<th width="40">状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="li">
				<c:if test="${li.auserId!=1 }">
				<tr class="text-c">
					<td><input type="checkbox" class="checkboxs" value="${li.auserId }" name=""></td>
					<td>${li.auserId }</td>
					<td>${li.auserName }</td>
					<td>${li.auserSex }</td>
					<td>${li.auserPhone }</td>
					<td>${li.auserEmail }</td>
					<td>${li.movieRole.roleName }</td>
					<td>${li.createTime }</td>
					<c:if test="${li.auserStatus==1 }">
						<td>
							<div style="width: 73px;" class="switchs" id="switch${li.auserId}" onclick="switchs('${li.auserId}');">
						        <input type="checkbox" name="check-3" value="${li.auserId}" class="lcs_check lcs_tt1" title="启用" checked="checked"/>
						    </div>
					    </td>
					</c:if>
					<c:if test="${li.auserStatus==2 }">
						<td class="td-status">
							<div style="width: 73px;" class="switchs" id="switch${li.auserId}" onclick="switchs('${li.auserId}');">
						        <input type="checkbox" name="check-3" value="${li.auserId}" class="lcs_check lcs_tt1" title="停用"/>
						    </div>
					    </td>
					</c:if>
					<td class="td-manage"><a title="编辑" href="javascript:;" onclick="member_edit('编辑','${pageContext.request.contextPath }/admin/usermodify/${li.auserId }','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="change_password('修改密码','${pageContext.request.contextPath }/admin/changeAdPassword/${li.auserId }','10001','600','270')" href="javascript:;" title="修改密码"><i class="Hui-iconfont">&#xe63f;</i></a> <a title="删除" href="javascript:;" onclick="member_del(this,'${li.auserId}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/lc_switch.js"></script>
<script type="text/javascript">
$(function(){
	$(".lcs_check").lc_switch();//调用状态
	
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "asc" ]],//默认第几个排序  asc升序  desc降序
		"bStateSave": false,//状态保存
		"aoColumnDefs": [
		  {"bVisible": false, "aTargets": [  ]}, //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,1,2,3,4,5,6,7,8,9]}// 制定列不参与排序
		]
	});
	/* $('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		]
	}); */
	
	
	
	
	//搜用户
	$("#button").click(function() {
		location.href = "${pageContext.request.contextPath }/admin/selectAdminLike?createTime="+$("#datemin").val()+"&createTime2="+$("#datemax").val()+"&user="+$("#user").val()+"";
		/* $.ajax({
			type: "GET",//传输方式
			url: "${pageContext.request.contextPath }/user/selectUserLike",//提交URL
			data: {	"createTime": $("#datemin").val(),
					"createTime2":$("#datemax").val(),
					"user":$("#user").val()}//提交的数据
			//dataType: "json",
			success: function(data) {
				//console.log(data);
				//location.href = "";
			}
    	}); */
	});
	
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '${pageContext.request.contextPath }/admin/deleteaddmin/'+id+'',
			dataType: 'json',
			success: function(data){
				if(data>0){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000});
					/* setTimeout(function(){
						location.reload();
				    },1000); */
				}
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
//批量删除
function batchDel (argument) {
    var ids = [];

    // 获取选中的id 
    $(".checkboxs").each(function() {
        if($(this).prop('checked')){
           ids.push($(this).val());
        }
    });

    layer.confirm('确认要删除吗？'+ids.toString(),function(){
        $.ajax({ 
        	type: "POST", 
        	url: "deleteBatch",
        	data: {'ids':ids.toString()}, 
        	success: function(data) { 
        		layer.msg('删除成功!',{icon:1,time:1000});
        		$(".checkboxs:checked").parents('tr').remove();
        		
        		/* setTimeout(function(){
        			window.location.reload(); 
			    },500); */
            	
        	}
        });
    });
  }
  
  //状态
  function switchs(id){
	var title=$("#switch"+id+" .lcs_check").attr("title");
	if(title=="启用"){
		layer.confirm('确认要停用吗？',function(index){
			$.ajax({ 
	        	type: "GET", 
	        	url: '${pageContext.request.contextPath }/admin/ablockup/'+id+'',
	        	success: function(data) { 
	        		$("#switch"+id+" .lcs_check").attr("title","停用");
	    			layer.msg('已停用!',{icon: 5,time:1000});
	    			$("#switch"+id+" .lcs_check").lcs_off();
	        	}
	        });
		});
	}else{
		layer.confirm('确认要启用吗？',function(index){
			$.ajax({ 
	        	type: "GET", 
	        	url: '${pageContext.request.contextPath }/admin/astartusing/'+id+'',
	        	success: function(data) { 
	        		$("#switch"+id+" .lcs_check").attr("title","启用");
	    			layer.msg('已启用!',{icon: 6,time:1000});
	    			$("#switch"+id+" .lcs_check").lcs_on();
	        	}
	        });	
		});
	}
  }
</script>
</body>
</html>
