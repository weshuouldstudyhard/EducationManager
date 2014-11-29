package cn.edu.fjnu.cdio4.xplan.action;

import org.apache.struts2.ServletActionContext;

import cn.edu.fjnu.cdio4.xplan.domain.LoginUser;
import cn.edu.fjnu.cdio4.xplan.service.ILoginUserService;

/**
 *类的作用：处理登录的action
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-13   上午02:10:07
 */
public class LoginAction extends BaseAction {
	private ILoginUserService loginUserService;
	private LoginUser user;

	
	public void setLoginUserService(ILoginUserService loginUserService) {
		this.loginUserService = loginUserService;
	}

	private String name;
	private String password;

	
	// 显示登录的页面
	@Override
	public String execute() throws Exception {
		return LOGIN;
	}

	// 处理登录的请求
	public String check() throws Exception {
		user = new LoginUser();
		//将密码进行加密
		user.setPassword(password);
		LoginUser loginUser = loginUserService.findByLogin(name, user.getPassword());
		if (loginUser != null) {// 登录成功
			// 放入session,重定向跳转到后台主页
			ServletActionContext.getRequest().getSession().setAttribute(LOGIN_IN_SESSION, loginUser);
			return MAIN;
		}
		return LOGIN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
