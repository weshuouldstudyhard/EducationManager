package  cn.edu.fjnu.cdio4.xplan.service;

import cn.edu.fjnu.cdio4.xplan.domain.User;

/**
 *类的作用：用户service的接口
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-28   下午2:45:28
 */
public interface IUserService extends IBaseService<User> {
	
	/**
	 * 查询用户名是否重复
	 * @param name 用户名
	 * @return true：用户名没有被注册，false：用户名已经被注册了
	 */
	public boolean findByName(String name);


	/**
	 * 查询邮箱是否已经注册过
	 * @param email 邮箱
	 * @return true：邮箱没有被注册，false：邮箱已经被注册了
	 */
	public boolean  findByEmail(String email);


	/**
	 * 查询该用户是否存在
	 * @param name 用户名
	 * @param password 密码
	 * @return
	 */
	public User findByLoginUser(String name, String password);

}
