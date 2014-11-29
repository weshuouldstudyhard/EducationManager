package cn.edu.fjnu.cdio4.xplan.domain;

import cn.edu.fjnu.cdio4.xplan.utils.Md5Encode;


/**
 *类的作用：用户登录实体
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-13   上午01:31:24
 */
public class LoginUser {
	private Long id;
	private String userName;
	private String password;
	public LoginUser() {
		super();
	}
	/**
	 * @param id
	 */
	public LoginUser(Long id) {
		super();
		this.id = id;
	}
	/**
	 * @param userName
	 * @param password
	 */
	public LoginUser(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	//对密码进行Md5加密
	public void setPassword(String password) {
		this.password =	Md5Encode.EncoderByMd5(password);
	}
	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", password=" + password + ", userName="
				+ userName + "]";
	}
	
	

}
