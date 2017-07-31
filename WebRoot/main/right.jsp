<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<style type="text/css">
	body{
			background-color: #E77B18;
		}
		/* 设置显示时间的div的样式 */
		#divTime{
			border:solid 1px gray;
			width:500px;
			height:150px;
			margin:auto;
			margin-top:50px;
			border-radius:10px;
			text-align: center;
		}
		/* 设置timeSpan中的时间样式 */
			#timeSpan{
				font-size: 70px;
			}
			/*设置dateSpan的时间样式*/
			#dateSpan{
				font-size:28px;
			}
		/*设置签到签退按钮的位置*/
		#sign{
			margin-top:30px;
			text-align:center;
		}
		/*设置签到签退按钮的样式*/
		input[type=button]{
			width:300px;
			height:100px;
			font-size:30px;
		}
		/*设置签到按钮的样式*/
		#bin{
			margin-right:150px;
		}
		/*设置签退按钮的样式*/
		#bout{
			margin-left:150px;
		}
</style>
<script type="text/javascript">
	function getTimeInfo(){
		var d=new Date();
		var h=d.getHours();
		var m=d.getMinutes();
		var s=d.getSeconds();
		if(s.toString().length<2){
			s="0"+s;
		}
		if(m.toString().length<2){
			m="0"+m;
		}
		$("#timeSpan").html(h+":"+m+":"+s);
		window.setTimeout(getTimeInfo, 1000);
	}
	function getDateInfo(){
		var date=new Date();
		var y=date.getFullYear();
		var m=date.getMonth()+1;
		var d=date.getDate();
		$("#dateSpan").html(y+"-"+m+"-"+d);
	}
	function signAjax(){
		var h=new Date().getHours();
		var inStatus=0;
		if(h>=9)
			inStatus=1;
		var unumber=${user.unumber};
		var inTime=$("#timeSpan").html();
		var inDate=$("#dateSpan").html();
		var dt={
				unumber:unumber,
				inTime:inTime,
				inDate:inDate,
				inStatus:inStatus,
				oper:'in'
		};
		$.get("user",dt,function(data){
			if("a"==data){
				alert("已经签到，不能重复签到");
			}else if(0==data){
				alert("签到成功-正常");
			}else if(1==data){
				alert("签到成功-迟到");
			}else{
				alert("签到失败");
			}
		});
	}	
	function signOutAjax(){
		//获取签退信息
			var h=new Date().getHours();
			var outStatus=0;
			if(h<18){
				outStatus=1;
			}
			var unumber=${user.unumber};
			var outTime=$("#timeSpan").html();
			var outDate=$("#dateSpan").html();
		//创建签退请求数据
			var dt={
				unumber:unumber,
				outTime:outTime,
				outDate:outDate,
				outStatus:outStatus,
				oper:'sout'
			};
		$.get("user",dt,function(data){
			if("a"==data){
				alert("请先签到");
			}else if(0==data){
				alert("签退成功-正常");
			}else if(1==data){
				alert("签退成功-早退");
			}else{
				alert("签退失败");
			}
		});
	}
</script>
</head>


<body onload="getTimeInfo();getDateInfo()">
	<!-- 显示当前时间 -->
	<div id="divTime">
		<span id="timeSpan"></span><br />
		<span id="dateSpan"></span>
	</div>
	<div id="sign">
		<input type="button" value="签到"  id="bin" onclick="signAjax()"/>
		<input type="button" value="签退"  id="bout" onclick="signOutAjax()"/>
	</div>
</body>

</html>
