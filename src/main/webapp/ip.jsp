<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当前IP和时间</title>
<script language=JavaScript>
	function showtime() {
		var now = new Date();
		
		document.clock.thetime.value = now.toString();
		setTimeout("showtime()", 1000);
	}
</script>

</head>
<body onload="showtime()" align="center">
<form name=clock width="100%">
<input name=thetime style="color:#0000ff;border:0;" size=100% type="text" >
</form>
request.getRemoteAddr()<%= request.getRemoteAddr() %><br>
request.getRemoteHost()<%= request.getRemoteHost() %><br>
request.getRemotePort()<%= request.getRemotePort() %><br>
request.getRemoteUser()<%= request.getRemoteUser() %><br>
request.getServerName()<%= request.getServerName() %><br>
request.getServerPort()<%= request.getServerPort() %><br>
request.getServletPath()<%= request.getServletPath() %><br>
==========================<br>
<%SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss 星期W  第w周");
Date date = new Date();
%>
<%=s.format(date)%>
</body>
</html>