<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
什么鬼啊 啊 啊啊 啊
<br>
<a href="ip.jsp" target="mainFrame" >当前IP和时间</a>
<br>
<a href="<%=request.getContextPath() %>/user/getuser" target='mainFrame'>用户</a>
<BR>
<a href="<%=request.getContextPath() %>/user/list" target='mainFrame'>用户列表</a>


</body>
</html>