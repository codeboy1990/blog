<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
<title>我的博客</title>

<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<script>
if(window.parent != window) {
	window.parent.location.href="<%=request.getContextPath() %>/login/index";
}
</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/main.js"></script>
<script type="text/javascript">
	var login = function(){
		var data = $("#login_frm").serialize();
		$.post("<%=request.getContextPath() %>/login/index", data, function(resp){
			if(resp['succ']) {
				window.location.href="<%=request.getContextPath() %>";
			}
		});
	};
	
	 //回车键的键值为13 TAB键值9
	function keyLogin(){
		  if (event.keyCode==13 && event.srcElement.type == 'button'){
		     document.getElementById("loginBtn").click();  //调用登录按钮的登录事件
		  }else if(event.keyCode==13){
			  event.keyCode = 9;
		  } 
	}
</script>
</head>

<body onload="document.all.userName.focus() ">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="<%=request.getContextPath() %>/images/top02.gif"><img src="<%=request.getContextPath() %>/images/top03.gif" width="900" height="147" /></td>
  </tr>
</table>
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
			<td width="221"><table width="95%" border="0" cellpadding="0"
					cellspacing="0" class="login-text01">

					<tr>
						<td><table width="100%" border="0" cellpadding="0"
								cellspacing="0" class="login-text01">
								<tr>
									<td align="center"><img
										src="<%=request.getContextPath()%>/images/ico13.gif"
										width="107" height="97" /></td>
								</tr>
								<tr>
									<td height="40" align="center">&nbsp;</td>
								</tr>
							</table></td>
						<td><img
							src="<%=request.getContextPath()%>/images/line01.gif" width="5"
							height="292" /></td>
					</tr>
				</table></td>
			<td>
				<form action="<%=request.getContextPath()%>/login/index"
					method="post" id="login_frm">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="31%" height="35" class="login-text02">用户名称：<br /></td>
							<td width="69%"><input style="width: 215px;" name="userName"
								type="text" onkeydown="keyLogin()" /></td>
						</tr>
						<tr>
							<td height="35" class="login-text02">密&nbsp;&nbsp;&nbsp;&nbsp;码：<br /></td>
							<td><input style="width: 215px;" name="password"
								type="password" onkeydown="keyLogin()" /></td>
						</tr>
						<tr>
							<td height="35">&nbsp;</td>
							<td><input name="Submit2" type="button" id="loginBtn"
								onclick="login();" class="right-button01" value="登录" /></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
</table>
</body>
</html>