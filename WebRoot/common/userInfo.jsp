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
		td{
			font-size:20px;
			font-family:宋体;
		}
		tr{
			height:50px;
		}
		/*设置div样式*/
		#showdiv{
			width:450px;
			margin:auto;
		}
	</style>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		function getUserInfo(){
			//创建请求数据
			var dt={
					rid:${user.rid},
					pnumber:${user.pnumber},
					oper:"info"
			};
			$.get("user",dt,function(data){
				eval("var data="+data);
				$("#rname").html(data.rname);
				$("#pname").html(data.pname);
			});
		}
	</script>
  </head>
  
  <body onload="getUserInfo()">
		<div id="showdiv">
			<table>
				<tr>
					<td width="100px">学号</td>
					<td width="300px">${user.unumber}</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td>${user.uname }</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>${user.usex }</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td>${user.uage }</td>
				</tr>
				<tr>
					<td>籍贯</td>
					<td>${user.uaddress }</td>
				</tr>
				<tr>
					<td>角色</td>
					<td id="rname">${user.rid }</td>
				</tr>
				<tr>
					<td>组长</td>
					<td id="pname">${user.pnumber }</td>
				</tr>
			</table>
		</div>
  </body>
</html>
