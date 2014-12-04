<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
<script type="text/javascript"></script>
<script src="js/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="js/validation/messages_cn.js" type="text/javascript"></script>
<title>您退出了SP系统</title>
<%@ include file="/js/common.jspf"%>
<link href="${pageContext.request.contextPath}/css/logout.css"
	rel="stylesheet" type="text/css">
</head>


<body>
	<table border="1px" cellspacing=0 cellpadding="150px" width=100%
		height=100% bgcolor="blue">
		<tr>
			<td align=center>
				<div id=Logout>
					<div style="background-color: green; height: 50px;"></div>
					<div id=LogoutOperate>
						<table>
							<tr>
								<td align="center"  width="300px"><img
									src="${pageContext.request.contextPath}/images/topic/logout2.png"
									border=0 /> <a
									href="${pageContext.request.contextPath}/index.jsp">跳转到登录界面</a>
								</td>

							</tr>
						</table>
					</div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>