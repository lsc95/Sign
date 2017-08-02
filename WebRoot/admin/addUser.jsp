<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//设置请求编码格式
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'updateUser.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#showdiv {
	width: 350px;
	margin: auto;
	margin-top: 30px;
}

select {
	width: 300px;
	height: 30px;
}

input[type=text] {
	width: 300px;
	height: 30px;
}
input[type=password] {
	width: 300px;
	height: 30px;
}
tr {
	height: 50px;
}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
			getRoleInfo();
		});
		function getRoleInfo(){
			$.get("admin",{"oper":"roleInfo"},function(data){
				eval("var roles="+data);
				var sel = $("#roleSel");
				sel.empty();
				for(var i=0;i<roles.length;i++){
					if(roles[i].rid!=4){
						sel.append("<option value="+roles[i].rid+">"+roles[i].rname+"</option>");							
					}
				}
				getPnumber();
			});
		}
		function getPnumber(){
			var rid = $("#roleSel").val();
			rid=Number(rid==3?"2":rid)+1;
			$.get("admin",{"oper":"userInfo","rid":rid},function(data){
				eval("var users="+data);
				var sel=$("#userSel");
				sel.empty();
				for(var i=0;i<users.length;i++){
					sel.append("<option value="+users[i].unumber+">"+users[i].rname+"---"+users[i].uname+"</option>");
				}
			});
		}
		function addUserSucess(){
			if("${flag}"){
				alert("添加用户成功!");
			}
		}
	</script>
</head>

<body onload="addUserSucess()">
	<div id="showdiv">
		<form action="admin" method="post">
			<input type="hidden" name="oper" value="addUser" />
			<table>
				<tr>
					<td>学号:</td>
					<td><input type="text" value="" name="unumber" /></td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td><input type="text" name="uname" value="" /></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" value="" name="upwd" /></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td>
						男<input type="radio" name="usex" value="男"  checked="checked"/>
						女<input type="radio" name="usex" value="女"> 
					</td>
				</tr>
				<tr>
					<td>年龄:</td>
					<td><input type="text" value="" name="uage" /></td>
				</tr>
				<tr>
					<td>地址:</td>
					<td><input type="text" name="uaddress" value="" /></td>
				</tr>
				<tr>
					<td>角色:</td>
					<td><select name="rid" id="roleSel" onchange="getPnumber()"></select>
					</td>
				</tr>
				<tr>
					<td>上级:</td>
					<td><select name="pnumber" id="userSel">
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="确认添加" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
