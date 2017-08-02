<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
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

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
function checkLast(){
	if(${page+1}>${pageCount}){
		alert("最后一页了！");
	}else{
		return true;
	}
	return false;
}
function checkFirst(){
	 if(${page-1}==0){
		alert("这是首页！");
	}else{
		return true;
	}
	 return false;
}
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>姓名</th>
        <th>签到时间</th>
        <th>签到状态</th>
        <th>签退时间</th>
        <th>签退状态</th>
        <th>日期</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="s">
	        <tr>
		        <td><input name="" type="checkbox" value="" /></td>
		        <td>${s.sid}</td>
		        <td>${uname }</td>
		        <td>${s.sintime }</td>
		        <td>${s.sinstatus==1?"迟到":"正常"}</td>
		        <td>${s.souttime}</td>
		        <td>${s.soutstatus==1?"早退":"正常" }</td>
		        <td>${s.sdate}</td>
	        </tr> 
        </c:forEach>
        
        
          
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${pageCount }</i>条记录，当前显示第&nbsp;<i class="blue">${page }&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="group?oper=showSign&unumber=${list[0].unumber}&uname=${uname}&page=${page-1}" onclick="return checkFirst();"><span class="pagepre"></span></a></li>
        <c:forEach begin="1" end="${pageCount}" var="i">
        	<li class="paginItem <c:if test='${page==i}'>current</c:if>"><a href="group?oper=showSign&unumber=${list[0].unumber}&uname=${uname}&page=${i}">${i }</a></li>
        </c:forEach>
        <li class="paginItem"><a href="group?oper=showSign&unumber=${list[0].unumber}&uname=${uname}&page=${page+1}" onclick="return checkLast();"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
