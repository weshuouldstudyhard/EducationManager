package cn.edu.fjnu.cdio4.xplan.service;

import cn.edu.fjnu.cdio4.xplan.domain.LoginUser;

/**
 *类的作用：用于处理用户登录的service
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-13   上午01:38:10
 */
public interface ILoginUserService extends IBaseService<LoginUser>{

	// 验证登录
	LoginUser findByLogin(String name, String password);

}
