package cn.edu.fjnu.cdio4.xplan.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 *类的作用：不需要对数据的进行CRUD的action索要继承的父类，
 *继承这个类后，让子类可以直接使用，不用创建对象了
 *1.日志输出，（）
 *2.将数据放入到web作用域中
 *3.可以直接调用request
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-12   下午06:09:08
 */
public abstract class BaseAction extends ActionSupport {
	// 重定向
	public static final String RELOAD = "reload";
	// 重定向到后台主页
	public static final String MAIN = "main";
	// 输出json字符串
	public static final String JSON = "json";
	// 存登录session里面key
	public static final String LOGIN_IN_SESSION = "loginUser";

	//日子的输出
	protected Logger logger = LoggerFactory.getLogger(getClass());

	//将数据放入到作用域中，也就是缓存中作用域常规四种作用域，而这个是放入到ActionContext
	protected void putContext(String key, Object object) {
		ActionContext.getContext().put(key, object);
	}
	
	//将数据放入到Sessiong
	protected void putSession(String key, Object object){
		ActionContext.getContext().getSession().put(key, object);
	}
	
	//将数据放入到valueStack中，凡是放入到valueStack中的数据都可以用EL表达式取出数据。
	protected void putValueStack(Object object){
		ActionContext.getContext().getValueStack().push(object);
	}
	

	HttpServletRequest request = ServletActionContext.getRequest();

}
