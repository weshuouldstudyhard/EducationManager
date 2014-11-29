package  cn.edu.fjnu.cdio4.xplan.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.fjnu.cdio4.xplan.domain.User;
import cn.edu.fjnu.cdio4.xplan.page.PageResult;
import cn.edu.fjnu.cdio4.xplan.page.UserQuery;
import cn.edu.fjnu.cdio4.xplan.service.IUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * 
 *类的作用：模板代码，action
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-10-31   下午04:08:36
 */
public class UserAction extends CRUDAction<User> {
	private IUserService userService;
	private PageResult<User> pageResult;
	private UserQuery baseQuery = new UserQuery();
	private User user  =  new  User();
	/*用户名*/
	private String name;
	/*邮箱*/
	private String email;
	
	private String password;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(UserQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public PageResult<User> getPageResult() {
		return pageResult;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getModel() {
		return user;
	}

	@Override
	protected void list() throws Exception {
		logger.debug("list");
		// 添加一个xx的查询列表
//		putContext("allDepts", departmentService.getAll());
		this.pageResult = userService.findPageResult(baseQuery);
	}

	@Override
	public String input() throws Exception {
		logger.debug("input");
		// 添加一个xx的选择列表
//		putContext("allDepts", departmentService.getAll());
		return INPUT;
	}
	
	/*用户登录信息的验证*/
	public String loginCheck(){
		System.out.println("UserAction："+user);
		
		User inputUser = new User();
		inputUser.setName(name);
		inputUser.setPassword(password);
		//查询这个用户是否存在
		User loginUser = userService.findByLoginUser(inputUser.getName(),inputUser.getPassword());
		if(loginUser != null){
			//用户名不为空，放入到actionContext的作用域中，并且跳转到程序的主页面
			putSession(LOGIN_IN_SESSION, user);
			return MAIN;
		}
		addFieldError("passwordAndusername", "用户名或者密码错误");
		return LOGIN;
	}
	
	/*当用户注销的时候，进入这个方法中*/
	public String loginOut(){
		/*将登录用户移除作用域，逻辑视图转到一个界面上*/
		ActionContext.getContext().getSession().remove(LOGIN_IN_SESSION);
		
		return null;
	}
	
	/**
	 * 利用ajax请求，检查用户名和邮箱是否注册过
	 */

	public String checkName(){
	
		System.out.println("userAction:name="+name);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if (id == null) {
				//说明，用户点击了“新建”，它的id为空
				out.print(userService.findByName(name));
			} else {
				//用户是修改个人的信息，则id并未改变
				User user = userService.get(id);
				// 没有修改名字,不要验证用户名不能重复
				if (user.getName().equals(name)) {
					out.print(true);
				} else {
					//用户修改了名字，要打印出“用户名已存在”的信息
					out.print(userService.findByName(name));
				}
			}
			return null;
	}
	
	  /*利用ajax请求，检查邮箱是否重复*/
	public String checkEmail(){
		System.out.println("userAction:email="+email);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(email != null){
			out.print(userService.findByEmail(email));
		}
		return null;
	}
	
	
	
	
	
	
	@Override
	// 保存的时候:如果出现转换异常:把字符串放到了Integer属性里面 ,默认会跳转到input指向的jsp页面
	@InputConfig(methodName = "input")
	public String save() throws Exception {
		logger.debug("save");
		
		if (id == null) {
			userService.save(user);
		} else {
			userService.update(user);
		}
		addActionMessage("保存成功");
		return LOGIN;
	}
	
	

	/**
	 * 注册页面注册成功后跳转到登录界面上
	 * @return 返回到登陆界面的逻辑视图上
	 */
	public String register(){
		//将用户注册的信息保存到数据库中
		userService.save(user);
     	return LOGIN;
	}
	


	// ajax删除
	@Override
	public String delete() throws Exception {
		logger.debug("delete");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (id != null) {
				userService.delete(id);
				out.print("{\"success\":true,\"msg\":\"删除成功\"}");
				// addActionMessage("删除成功");不能,ajax删除是不能通过addActionMessage方法消息
			} else {
				out.print("{\"success\":false,\"msg\":\"不能获取到id的值\"}");
			}
		} catch (Exception e) {
			out.print("{\"success\":false,\"msg\":\""+e.getMessage()+"\"}");
		}
		return null;
	}

	@Override
	protected void beforeInput() throws Exception {
		logger.debug("beforeInput");
		if (id != null) {
			user = userService.get(id);// 回显
		}
	}

	@Override
	protected void beforeSave() throws Exception {
		logger.debug("beforeSave");
		if (id == null) {
			user = new User();
		} else {
			// user持久状态
			user = userService.get(id);// 把数据从数据库加载出来,没有在jsp页面出现的属性不会丢失
		}
	}	

}
