<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<title>系统登录页</title>

</head>
<body>
<s:form action="login_check">
<div class="container-login">
<div class="login-pic">
<div class="login-text">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
		<td width="19%" height="28">用户名：</td>
		<td colspan="2"><input name="name" type="text" value="admin" size="18" /></td>
	  </tr>
	  <tr>
		<td height="31">&nbsp;密&nbsp;码：</td>
		<td colspan="2"><input name="password" type="password" value="admin" size="18" /></td>
	  </tr>
	 
	  <tr>
		<td height="30">&nbsp;</td>
		<td colspan="2">
		<input type="image" src="images/denglu_bg_03.gif" /><a href="#">
		<img src="images/giveup_bg_03.gif" name="Image2" width="40" height="22"
		 border="0" id="Image2" onmouseover="MM_swapImage('Image2','','images/giveup_h_03.gif',1)"
		 onmouseout="MM_swapImgRestore()" /></a>
		 </td>
	  </tr>
	</table>

</div>
</div><!--"login-pic"end-->
</div><!--"container-login"end-->
</s:form>
</body>
</html>
