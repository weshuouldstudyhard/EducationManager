package  cn.edu.fjnu.cdio4.xplan.service.impl;

import java.util.List;

import cn.edu.fjnu.cdio4.xplan.domain.LoginUser;
import cn.edu.fjnu.cdio4.xplan.domain.User;
import cn.edu.fjnu.cdio4.xplan.service.IUserService;

/**
 *类的作用：用户service的实现
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-28   下午2:45:40
 */
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

	/* (non-Javadoc)
	 * @see cn.edu.fjnu.cdio4.xplan.service.IUserService#findByName(java.lang.String)
	 */
	public boolean findByName(String name) {
		String hql = "select count(o) from User o where o.name =?";
		Long count = (Long) findByHql(hql, name).get(0);
		System.out.println("count:"+count);
		if (count > 0) {
			return false;
		}
		return true;
	}

	/*
	 *
	 * (non-Javadoc)
	 * @see cn.edu.fjnu.cdio4.xplan.service.IUserService#findByEmail(java.lang.String)
	 */
	public boolean findByEmail(String email) {
		String hql = "select count(o) from User o where o.email =?";
		Long count = (Long) findByHql(hql, email).get(0);
		if (count > 0) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see cn.edu.fjnu.cdio4.xplan.service.IUserService#findByLoginUser(java.lang.String, java.lang.String)
	 */
	public User findByLoginUser(String name, String password) {
		//根据用户名和密码同时查询，看是否存在
		String hql = "select o from User o where o.name=? and o.password=?";
		List<User> list = findByHql(hql, name, password);
		if (list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

}
