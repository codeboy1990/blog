<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<body>
<h2>Hello World!</h2>

<a href='<%=request.getContextPath() %>/user/getuser'>GETuser</a>

<%= request.getSession().getAttribute("login_admin") %>
<a href='<%=request.getContextPath() %>/login/index'>登录</a>
<a href='<%=request.getContextPath() %>/login/logout'>登出</a>
</body>
</html>
