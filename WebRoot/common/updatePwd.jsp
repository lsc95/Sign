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
  </head>
  
  <body>
		<div id="showdiv">
			<table>
				<tr>
					<td width="100px">原始密码</td>
					<td width="350px"><input type="password"  name="oldPwd" id="oldPwd" placeholder="情输入原始密码"/></td>
				</tr>
				<tr>
					<td>新密码</td>
					<td><input type="password" name="newPwd" id="newPwd" placeholder="请输入新的密码" /></td>
				</tr>
			</table>
		</div>
		<div id="div01">
			<input type="button" value="确认修改" />
		</div>
  </body>
</html>
