package cn.edu.fjnu.cdio4.xplan.domain;

import cn.edu.fjnu.cdio4.xplan.utils.Md5Encode;

/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-28   下午1:27:27
 */
public class User {

	private Long id;
	private String name;
	private String email;
	private String password;
	
	
	public User() {
	}


	/**
	 * @param id
	 */
	public User(Long id) {
		super();
		this.id = id;
	}


	/**
	 * @param name
	 * @param email
	 * @param password
	 */
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		if(password != null){
			//对传入的密码进行MD5加密
			this.password = Md5Encode.EncoderByMd5(password);
		}
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
	
}
