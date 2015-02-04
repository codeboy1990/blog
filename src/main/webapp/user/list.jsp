<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/base.jsp" %>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.tabfont01 {
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}

.font051 {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
-->
</style>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<SCRIPT language=JavaScript>
	function selectAll() {
		var obj = document.fom.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				obj[i].checked = true;
			}
		}
	}

	function unselectAll() {
		var obj = document.fom.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
	}

	function link() {
		document.getElementById("fom").action = "addrenwu.htm";
		document.getElementById("fom").submit();
	}
</SCRIPT>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="82" background="../images/nav04.gif">
							<table width="98%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="21">
										<img src="../images/ico07.gif" width="20" height="18" />
									</td>
									<td width="538">
										ID： <input id="userId" name="userId" type="text" size="12" />
										账号：<input id="userName" name="userName" type="text" size="12" />
										按时间：<input id="beginTime" name="beginTime" type="text" size="12" /> -
										<input id="endTime" name="endTime" type="text" size="12" />
										<input name="Submit4" type="button" disabled="disabled" class="right-button02" onclick="search()" value="查 询" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>

		<tr>
			<td>
				<table id="subtree1" style="display:" width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td height="40" class="font42">
										<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
											<tr class="CTitle">
												<td height="22" colspan="6" align="center" style="font-size: 16px">
													用户列表
												</td>
											</tr>
											<tr bgcolor="#EEEEEE" align="center" >
												<td width="6%">ID</td>
												<td width="10%">账号</td>
												<td width="10%">昵称</td>
												<td width="10%">密码</td>
												<td width="16%">注册时间</td>
<!-- 												<td width="8%">注册IP</td> -->
<!-- 												<td width="3%">注册来源</td> -->
<!-- 												<td width="3%">用户状态</td> -->
												<td width="14%">操作</td>
											</tr>
											<c:forEach items="${userList }" var="user" begin="0">
												<tr bgcolor="#FFFFFF" align="center" >
													<td>${user.userId }</td>
													<td>${user.userName }</td>
													<td>${user.nickName }</td>
													<td>${user.passWord }</td>
													<td><fmt:formatDate value="${user.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
													<%-- 													<td>${user.regSource }</td> --%>
<%-- 													<td>${user.userState }</td> --%>
													<td>
														<a href="<%=basePath %>/user/reqUpdate?userId=${user.userId }">编辑</a>
													</td>
												</tr>
											</c:forEach>
										</table>
									</td>
								</tr>
							</table>
							<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td height="6">
										<img src="<%=basePath %>/images/spacer.gif" width="1" height="1" />
									</td>
								</tr>
								<tr>
									<td height="33">
										<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
											<tr>
												<td width="50%">
													第 <span class="right-text09 red">${pageNo }</span> 页 |
													共 <span class="right-text09 red">${totalPage }</span> 页 |
													共 <span class="right-text09 red">${totalRecord }</span> 条
												</td>
												<td width="49%" align="right">
													[<a href="javascript:goPage(1)" class="right-font08">首页</a> |
													<a href="javascript:goPage(${pageNo -1})" class="right-font08">上一页</a> |
													<a href="javascript:goPage(${pageNo +1})" class="right-font08">下一页</a> |
													<a href="javascript:goPage(${totalPage})" class="right-font08">末页</a>] 转至：
												</td>
												<td width="1%">
													<table width="20" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td width="1%">
																<input name="pageNo" id="pageNo" type="text" class="right-textfield03" size="1" />
															</td>
															<td width="87%">
																<input onclick="goPage(document.getElementById('pageNo').value)" type="button" class="right-button06" value=" " />
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		function goPage(pageNo) {
			var curPageNo = ${pageNo};
			var totalPage = ${totalPage};
			if (pageNo == curPageNo || pageNo > totalPage || pageNo < 1) {
				return;
			}
			window.location = "<%=basePath %>/user/list?pageNo=" + pageNo;
		}
		function search() {
			var userId = document.getElementById("userId").value;
			var userName = document.getElementById("userName").value;
			var beginTime = document.getElementById("beginTime").value;
			var endTime = document.getElementById("endTime").value;
			var params = "";
			if (userId != null && userId.length > 0) {
				params += "&userId=" + userId;
			}
			if (userName != null && userName.length > 0) {
				params += "&userName=" + userName;
			}
			if (beginTime != null && beginTime.length > 0) {
				params += "&beginTime=" + beginTime;
			}
			if (endTime != null && endTime.length > 0) {
				params += "&endTime=" + endTime;
			}
			window.location = "<%=basePath %>/user/list?1=1" + params;
		}
	</script>
</body>
</html>
