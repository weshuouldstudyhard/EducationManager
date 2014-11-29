<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
	
    <script language="javascript" type="text/javascript" src="js/jquery1.js"></script>
    <script language="javascript" type="text/javascript"></script>
    <script type="text/javascript" src="login.js"></script>  
    <script src="js/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="js/validation/jquery.validate.js" type="text/javascript"></script>
<script src="js/validation/messages_cn.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
$().ready(function() {
	//这个里面可以添加自定一定jQuery验证
	$("#loginForm").validate({
		//定义规则
		rules: {
			name:{
				required:true
			},
			password:{
				required:true
			}
		},	
		//消息提示
		messages: {
				name:{
				required:""
			},
			password:{
				required:""
			}
		}
	});
});
//-->
</script>
      
    
</head>
<s:form  action="user_loginCheck" id="loginForm">
<body >
<form method="post">

<div class="logo wap"><a href="/EducationManager/WEB-INF/views/home_page.jsp" ><img src="images/SPImages/logos/SPLogo.png" width="260" height="99" border="0"></a></div>
<div class="lo_ct">
    <div class="lo_bg wap">
        <ul class="lo_list">
            <li class="lo_list_text"><span>用户名</span><input class="us_name" name="name"  onFocus="$(this).prev('span').hide()" onBlur="if(!value){$(this).prev('span').show()}" type="text"></li>
            <li class="lo_list_text"><span>密码</span><input class="us_pwd"   name="password"  value="" onFocus="$(this).prev('span').hide()" onBlur="if(!value){$(this).prev('span').show()}" type="password"></li>
            
            <li>
                <span class="lt" onMouseOver="$('em').show()" onMouseOut="$('em').hide()">
				<input name="checkbox" class="IsSave" id="IsSave" title="" value="1" type="checkbox">
				<label for="IsSave" title="">记住我</label></span>
                <em style="display:none;" class="remberpass">&nbsp;请勿在公共电脑使用此选项</em>
                <a class="forget rt" href="findpwd.html" title="忘记密码">忘记密码</a>
                <span class="errotip" id="ListMsg"></span>
            </li>
           <!-- 显示错误 -->
			<font color="red"><s:fielderror  fieldName="passwordAndusername"/></font>
            <li>
            	<s:submit action="user_loginCheck" value="登录"></s:submit>
<!--                 <a class="lo_bnt lt" href="user_loginCheck.action?name=" onClick="submitForm()" title="登录">登录</a>
 -->                <a class="free_join rt" href="register.action" onclick="" title="注册">注册</a>
            </li>
         
      </ul>
    </div>
</div>
<p class="lo_bt">
    <a href="homePage.action">返回首页</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="mailto:123@studypower.net">联系我们</a><a href="http://"></a></p>

</form>

</body>
</s:form>
</html>
