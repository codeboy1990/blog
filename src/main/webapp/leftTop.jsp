<%-- <%@page import="com.sf.rss.admin.web.entity.AdminUser"%> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="css/css.css" rel="stylesheet" type="text/css" />

<style>
a {
	text-decoration: none
}
</style>

<body style="margin:0; border-right:1px solid #ddd;">
	<table border="0" cellpadding="0" cellspacing="0" class="left-table01">
		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="215" height="75" background="<%=request.getContextPath() %>/images/nav01.gif">
							<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td width="25%" rowspan="2"><img src="<%=request.getContextPath() %>/images/ico02.gif"
										width="35" height="35" /></td>
									<td width="75%" height="22" class="left-font01">
										您好，<span class="left-font02"><a href="<%=request.getContextPath() %>/user/getuser?userName=${login_admin.userName }" target='mainFrame'>${login_admin.userName }</a></span>
									</td>
								</tr>
								<tr>
									<td height="22" class="left-font01">
										[&nbsp;<a href="<%=request.getContextPath() %>/login/logout" target="_top" class="left-font01">退出</a>&nbsp;]
										[&nbsp;<a href="<%=request.getContextPath() %>/admin/users/goUpdatePwd" target="_top" class="left-font01">修改密码</a>&nbsp;]
									</td>
								</tr>
								<tr>
									<td height="22" class="left-font01">当前IP：</td>
									<td height="22" class="left-font01">
									<font color="blue"><%=request.getRemoteAddr() %></font>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				</td>
				</tr>
				</table>
</body>
</html>
