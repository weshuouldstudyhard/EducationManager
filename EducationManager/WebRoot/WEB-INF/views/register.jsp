<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="css/register.css">
<script src="js/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="js/validation/jquery.validate.js" type="text/javascript"></script>
<script src="js/validation/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
$().ready(function() {
	//等body加载完毕之后才执行,下面的写的代码必须英文版本
	//这个里面可以添加自定一定jQuery验证
	$("#registerForm").validate({
		//定义规则
		rules: {
			name:{
				required:true,
				remote:"user_checkName.action?id="+$("#id").val()
			},
			email:{
				required:true,
				email:"email",
				remote:"user_checkEmail.action?id="+$("#id").val()
			},
			newPassword:{
				required:true,
				maxlength:20,
				minlength:6
			},
			confirmPassword:{
				required:true,
				maxlength:20,
				minlength:6,
				equalTo: "#newPassword"
			}
		},	
		//消息提示
		messages: {
				name:{
				required:"用户名必须填写",
				remote:"此用户名已经注册过"
			},
			email:{
				required:"邮箱必须填写",
				email:"密码格式不对",
				remote:"此邮箱已经存在"
				
			},
			newPassword:{
				required:"密码必须填写",
				maxlength:"超出范围了",
				minlength:"长度不能小于6位"
			},
			confirmPassword:{
				required:"密码必须填写",
				maxlength:"超出范围了",
				minlength:"长度不能小于6位",
				equalTo:"密码不一致,请重输"
			}
		}
	});
});
//-->
</script>

<title>注册帐号</title>

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
.STYLE1 {
	color: #000000;
	font-weight: bold;
}
-->
</style>
</head>

<body>
<s:form action="user_register" id="registerForm">
<s:hidden id="id"></s:hidden>
<div class="logo"><a href="/EducationManager/WEB-INF/views/home_page.jsp" ><img src="images/SPImages/logos/SPLogo.png" width="260" height="99" border="0"></a></div>
<div class="header clearfix">
    <div class="container">
         <div class="nav">
             <ul class="clearfix">
				<a href="homePage.action" class="STYLE1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="login.action" class="STYLE1">登录</a>
             </ul>
         </div>
    </div>
</div>

	<div id="main">
		<h1 class="reg-title">欢迎注册StudyPower</h1>	
		<div id="reg">

				<form id="registerForm" method="post" name="registerForm"  onsubmit="Submit()" action="http://">
				
				<dl class="reg-wrap">
					<dd>
						<div class="reg-item">
							<label for="loginName">用户名</label>
							<span class="input-bg">
							<input tabindex="1" id= "name" name="name" autocomplete="off"  maxlength="100" class="ipt tipinput" type="text"></span>
							<b class="icon-loginName"></b>						
							</div>
						<span id="tips-loginName" class="text-tips tips-loginName"></span>
					</dd>
					<dd>
						<div class="reg-item">
							<label for="loginEmail">邮箱</label>
							<span class="input-bg">
							<input tabindex="1" name="email" autocomplete="off"  maxlength="100" class="ipt tipinput" type="text"></span>
							<b class="icon-loginEmail"></b>						
						</div>
						<span id="tips-loginEmail" class="text-tips tips-loginEmail">注册邮箱即为往后登录ID</span>
					</dd>
					<dd>
						<div class="reg-item">
							<label for="password">密码</label>
							<span class="input-bg">
							<input tabindex="2" id="newPassword" name="password" autocomplete="off" class="ipt tipinput" type="password"></span>
							<b class="icon-password"></b>						
						</div>
						<span id="tips-password" class="text-tips tips-password">6-20个字符，（区分大小写）</span>
					</dd>
					<dd>
						<div class="reg-item">
							<label for="rePassword">确认密码</label>
							<span class="input-bg">
							<input tabindex="3" name="confirmPassword" autocomplete="off" class="ipt tipinput" type="password"></span>
							<b class="icon-rePassword "></b>						
						</div>
						<span id="tips-rePassword" class="text-tips tips-rePassword">请再次输入密码</span>
					</dd>
					<dd class="submit">
					<s:submit action="user_register" value="立即注册"></s:submit>
<!-- 					  <input name="submit"  type="submit" id="regSubmitBtn" value="立即注册"  text="立即注册" >
 -->					</dd>
				</dl>
				</form>
	  </div>
</div>
	</div>

</s:form>
</body>


</html>