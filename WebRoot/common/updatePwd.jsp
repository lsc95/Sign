<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		/*设置背景颜色*/
		body{
			background-color:#e77b18;
		}
		/*设置table样式*/
		table{
			margin:auto;
		}	
		td{
			font-size:20px;
			font-family:宋体;
		}
		tr{
			height:80px;
		}
		input{
			width:200px;
			height:40px;
		}
		/*设置div样式*/
		#showdiv{
			border:solid 1px;
			width:500px;
			margin:auto;
			margin-top:100px;
			border-radius:10px;
		}
		#div01{
			margin-top:50px;
			text-align:center;
		}
	</style>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		var flag=false;
		//原始密码校验
		function checkOldPwd(){
			//创建请求数据
			var oldPwd=$("#oldPwd").val();
			var dt={
					oldPwd:oldPwd,
					oper:"pwd"
			};
			$.get("user",dt,function(data){
				if(eval(data)){
					$("#oldSpan").css("color","green");
					$("#oldSpan").html("密码正确");
					flag=true;
				}else{
					$("#oldSpan").css("color","darkred");
					$("#oldSpan").html("密码错误");
				}	
			});
		}
		function updatePwd(){
			if(flag){
				var fm =document.getElementById("fm");
				fm.submit();
			}else{
				$("#oldSpan").css("color","darkred");
				$("#oldSpan").html("原始密码错误");
			}
		}
	</script>
  </head>
  
  <body>
  	<form action="user" method="post" id="fm" target="_top">
  		<input type="hidden" name="oper" value="newPwd" />
		<div id="showdiv">
			<table>
				<tr>
					<td width="100px">原始密码</td>
					<td width="350px">
						<input type="password"  name="oldPwd" id="oldPwd" placeholder="情输入原始密码" onblur="checkOldPwd()"/>
						<span id="oldSpan"></span>
					</td>
				</tr>
				<tr>
					<td>新密码</td>
					<td><input type="password" name="newPwd" id="newPwd" placeholder="请输入新的密码" /></td>
				</tr>
			</table>
		</div>
		<div id="div01">
			<input type="button" value="确认修改" onclick="updatePwd()"/>
		</div>
	</form>
  </body>
</html>
