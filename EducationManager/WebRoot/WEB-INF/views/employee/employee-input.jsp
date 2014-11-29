<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" media="screen" href="js/validation/css/screen.css" />
<script src="js/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="js/validation/jquery.validate.js" type="text/javascript"></script>
<script src="js/validation/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
$().ready(function() {
	//等body加载完毕之后才执行,下面的写的代码必须英文版本
	//这个里面可以添加自定一定jQuery验证
	$("#employeeForm").validate({
		//定义规则
		rules: {
			name:{
				required:true
			},
			age:{
			//年龄的只能是2位数，而且必须输入的是数字
			maxlength:2,
			minlength:2,
			number:true
			}
		},	
		//消息提示
		messages: {
			name:{
				required:"名称必须填写"
			},
			age:{
			//年龄的只能是2位数，而且必须输入的是数字
			maxlength:"请输入年龄的范围10-99",
			minlength:"请输入年龄的范围10-99",
			number:"请输入数字"
			}
		}
	});
});
//-->
</script>
<title>CDIO第四小组-案例Employee编辑界面</title>
<style type="text/css">
body{
	text-align:center;
	width:1102px;
	margin-top:70px;
	background-color: rgb(145,198,84);
}

</style>
</head>
<body>
<s:form id="employeeForm" action="employee_save">
<s:hidden id="id" name="id"/>
<s:hidden name="baseQuery.currentPage"/>
<s:hidden name="baseQuery.pageSize"/>
<div class="content-right">
<div class="content-r-pic"><div style="margin:5px auto auto 12px;"><img src="images/canping.gif" width="138" height="17" /></div></div>
<!--%@include file="/WEB-INF/views/message.jsp"%
-->
<div class="content-text">
<div class="square-order">
  <div style="border:1px solid #cecece;">
  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr bgcolor="#FFFFFF">
    <td>&nbsp;</td>
  </tr>
</table>
  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr  bgcolor="#FFFFFF">
      <td width="13%" height="30" align="center">名称</td>
      <td width="36%" align="left">
        <s:textfield name="name"/>
      </td>
    </tr>
     <tr  bgcolor="#FFFFFF">
      <td width="13%" height="30" align="center">年龄</td>
      <td width="36%" align="left">
        <s:textfield name="age"/>
      </td>
    </tr>
  </table></div>
<div class="order-botton">
<div style="margin:1px auto auto 1px;">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><input type="image" src="images/order_tuo.gif"/></td>
    <td>&nbsp;</td>
    <td><a href="#"><img src="images/order_tuo.gif" border="0" /></a></td>
    <td>&nbsp;</td>
    <td><a href="#"><img src="images/order_tuo.gif" border="0" /></a></td>
  </tr>
</table></div>
</div>
</div><!--"square-order"end-->
</div><!--"content-text"end-->
<div class="content-bbg"><img src="images/content_bbg.jpg" /></div>
</div><!--"content-right"end-->
</s:form>
</body>
</html>

