<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
<title>【${forum.name}】中的主题列表</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/forum.css" />
<script type="text/javascript">
	function onSortByChange(selectedValue) {
		if (selectedValue == 0) {
			$("select[name=asc]").attr("disabled", "disabled");
		} else {
			$("select[name=asc]").removeAttr("disabled");
		}
	}
	$(function() {
		if ($("select[name=orderBy]").val() == '0') {
			$("select[name=asc]").attr("disabled", "disabled");
		}
	});
</script>
</head>
<%@include file="/WEB-INF/views/head.jsp" %>
<body>
	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/images/topic/title_arrow.gif" />
				【${forum.name}】中的主题列表
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
	<!-- form表单-->
	<s:form  id ="domainForm" action="forum_showForum?id=%{id}">
		<div id="MainArea">
			<div id="PageHead"></div>  
			<center>
				<div class="ItemBlock_Title1" style="width: 98%;">
					<font class="MenuPoint"> &gt; </font>
					<s:a action="discussion.action">论坛</s:a>
					<font class="MenuPoint"> &gt; </font> ${forum.name} <span
						style="margin-left:30px;"> 
						<s:a
							action="topic_addTopic?id=%{#forum.id}">
							<img align="absmiddle"
								src="${pageContext.request.contextPath}/images/topic/publishNewTopic.png" />
						</s:a> </span>
				</div>

				<div class="ForumPageTableBorder">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<!--表头-->
						<tr align="center" valign="middle">
							<td width="3" class="ForumPageTableTitleLeft"><img
								border="0" width="1" height="1"
								src="${pageContext.request.contextPath}/images/topic/blank.gif" />
							</td>
							<td width="50" class="ForumPageTableTitle">
								<!--状态/图标-->&nbsp;</td>
							<td class="ForumPageTableTitle">主题</td>
							<td width="130" class="ForumPageTableTitle">作者</td>
							<td width="100" class="ForumPageTableTitle">回复数</td>
							<td width="130" class="ForumPageTableTitle">最后回复</td>
							<td width="3" class="ForumPageTableTitleRight"><img
								border="0" width="1" height="1"
								src="${pageContext.request.contextPath}/images/topic/blank.gif" />
							</td>
						</tr>
						<tr height="1" class="ForumPageTableTitleLine">
							<td colspan="8"></td>
						</tr>
						<tr height=3>
							<td colspan=8></td>
						</tr>

						<!--主题列表,位于同一个版块下的所有的帖子-->
						<tbody class="dataContainer" datakey="topicList">

								<s:iterator value="pageResult.rows">
								<tr height="35" id="d0" class="template">
									<td></td>
									<td class="ForumTopicPageDataLine" align="center"><img
										src="${pageContext.request.contextPath}/images/topic/topicType_${type}.gif" />
									</td>
									<td class="Topic"><s:a cssClass="Default"
											action="topic_showTopic?id=%{id}">${title}</s:a></td>
									<td class="ForumTopicPageDataLine">
										<ul class="ForumPageTopicUl">
											<li class="Author">${user.name}</li>
											<li class="CreateTime"><s:date name="postTime"
													format="yyyy-MM-dd HH:mm:ss" /></li>
										</ul></td>
									<td class="ForumTopicPageDataLine Reply" align="center"><b>${replyCount}</b>
									</td>
									<td class="ForumTopicPageDataLine">
										<ul class="ForumPageTopicUl">
											<li class="Author">${lastReply.user.name}</li>
											<li class="CreateTime"><s:date name="lastReply.postTime"
													format="yyyy-MM-dd HH:mm:ss" />
											</li>
										</ul></td>
									<td></td>
								</tr>
							</s:iterator>

						</tbody>
						<!--主题列表结束-->

						<tr height="3">
							<td colspan="9"></td>
						</tr>

					</table>


				</div>
			</center>
			<!-- 包含分页的代码 -->
	<%@include file = "/WEB-INF/views/page.jsp" %>
		</div>
	</s:form>

<br/>
	<div class="Description">
	<br/>
		说明：<br /> 
		1，主题默认按最后更新的时间降序排列。最后更新时间是指主题最后回复的时间，如果没有回复，就是主题发表的时间。<br />
		2，帖子有普通、置顶、精华之分。置顶贴始终显示在最上面，精华贴用不同的图标标示。<br />
	</div>

</body>
</html>
