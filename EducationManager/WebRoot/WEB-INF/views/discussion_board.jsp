<%@page import="cn.edu.fjnu.cdio4.xplan.service.impl.ForumServiceImpl"%>
<%@page import="cn.edu.fjnu.cdio4.xplan.service.IForumService"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="cn.edu.fjnu.cdio4.xplan.domain.Forum"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>讨论区</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><!--meta charset="utf-8" /-->


<link type="text/css" href="css/discussion.css" rel="stylesheet" />
<link type="text/css" href="css/navigation.css" rel="stylesheet" />
  <!-- 引用的script -->
  <script type="text/javascript" src="js/overturn.js"></script>
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

<!--引入导航栏 -->
<%@include file="/WEB-INF/views/head.jsp" %>

<div class="12_img" >
	 <% 
    int column = 4;
     List<Forum> forus =  (List<Forum>)session.getAttribute("allForums");
    int rows = (forus.size() +column -1) / column;
    for(int i = 0; i < rows; i++  ){
    %>
  
	<div class="row01">
		<%
		for(int j = 0; j < column; j++){
		if((i*column+j) == forus.size())break;
		Forum forum = forus.get(i*column+j);
		session.setAttribute("forumId",forum.getId());
		session.setAttribute("firstIconPath", forum.getFirstIconPath());
		session.setAttribute("lastIconPath", forum.getLastIconPath());
		Long strLong = System.currentTimeMillis()+(i*column+j);
		String dataUrlIconName = "im"+strLong.toString();
		String inputIconName = "brand_double_pic"+strLong.toString();
		String inputIconBackName = "brand_double_fpic" + strLong.toString();
		 %>
		
				<div class="overturn"> 
					<a href="forum_showForum.action?id=${forumId}" target="_self">
	                    <img src="${firstIconPath}" 
						data-url="${firstIconPath}"		
						data-url="${lastIconPath}" id="<%=dataUrlIconName%>">
	                    <input value="${firstIconPath}" id="<%=inputIconName%>" type="hidden">
	                    <input value="<%=forum.getLastIconPath()%>" id="<%=inputIconBackName%>" type="hidden">
             	   </a> 
				</div>
		<%
		if((i*column+j + 1) == forus.size())break;
			}
		 %>
	</div>

	<%} %>
</div>
 <!-- 12图代码 借宿 -->
 <br><br><br><br><br>

</body>
</html>







