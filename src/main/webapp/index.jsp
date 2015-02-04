<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="icon" href="images/favicon.ico" type="image/x-icon" />

<title>我的博客</title>
</head>

<frameset rows="90,*,30" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize"
		id="topFrame" title="topFrame" />
	<frameset cols="213,*" frameborder="no" border="0" framespacing="0">

		<frameset rows="75,*" cols="213" frameborder="no" border="0" framespacing="0">
 			<frame src="leftTop.jsp" name="leftTopFrame" scrolling="No"
				noresize="noresize" id="leftTopFrame" title="leftTopFrame" /> 
			<frame src="left.jsp" name="leftFrame" scrolling="Yes"
				noresize="noresize" id="leftFrame" title="leftFrame" />
		</frameset>

		<frame src="mainfra.jsp" name="mainFrame" id="mainFrame"
			title="mainFrame" />
	</frameset>
	
	<frame src="footer.jsp" name="footerFrame" scrolling="No"
		noresize="noresize" id="footerFrame" title="footerFrame" />
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html>
