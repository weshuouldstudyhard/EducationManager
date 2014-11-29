package cn.edu.fjnu.cdio4.xplan.service.impl;

import java.util.List;

import cn.edu.fjnu.cdio4.xplan.domain.LoginUser;
import cn.edu.fjnu.cdio4.xplan.service.ILoginUserService;


/**
 *类的作用：登录用户的service的实现类
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-13   上午01:38:48
 */
public class LoginUserServiceImpl extends BaseServiceImpl<LoginUser> implements ILoginUserService{


	public LoginUser findByLogin(String name, String password) {
		String hql = "select o from LoginUser o where o.userName=? and o.password=?";
		List<LoginUser> list = findByHql(hql, name, password);
		// 映射文件:<property name="name" unique="true" />
		if (list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

}
