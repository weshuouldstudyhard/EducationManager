<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>讨论区</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /><!--meta charset="utf-8" /-->


<link type="text/css" href="css/discussion.css" rel="stylesheet" />
<link type="text/css" href="css/navigation.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.10.1.js"></script>

<style type="text/css">
<!--
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
-->
</style>
</head>
 
<body>
<br>

    <div align="right" ><s:a  action="logout"><img src="${pageContext.request.contextPath}/images/topic/logout.png" width="60px" height="40px" target="_parent" alt="退出"/>
       
    </s:a>
   </div>
<div id="logo">	<a href="#"><img src="images/SPImages/logos/SPLogo.png" name="SPLogo" border="0" id="SPLogo"></a></img> </div>
<div align="right"><font color="blue" size="16px">欢迎您${user.name}</font>
</div>

 <!-- 导航代码 开始 -->
<div id="nav">
	<ul>
        <li><a href="http:..."><strong><span></span><span class="active"></span></strong></a></li>
		<li><a href="http:..."><strong><span></span><span class="active"></span></strong></a></li>
		
		<li><a href="#"><strong><span>个人信息</span><span class="active">个人信息</span></strong></a></li>
		<li><a href="#"><strong><span>关于</span><span class="active">关于</span></strong></a></li>
		<li><a href="mailto:123@studypower.net"><strong><span>联系我们</span><span class="active">联系我们</span></strong></a></li>
		<li><a href="resourcesInfo.action"><strong><span>资源区</span><span class="active">资源区</span></strong></a></li>
		<li><a href="discussion.action"><strong><span>讨论区</span><span class="active">讨论区</span></strong></a></li>
		<li><a href="homePage.action"><strong><span>首页</span><span class="active">首页</span></strong></a></li>	
	</ul>
</div>
<!-- 导航代码结束 -->
</body>
</html>