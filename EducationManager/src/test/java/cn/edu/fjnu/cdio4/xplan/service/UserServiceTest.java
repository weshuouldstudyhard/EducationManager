package cn.edu.fjnu.cdio4.xplan.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.fjnu.cdio4.xplan.domain.User;
import cn.edu.fjnu.cdio4.xplan.service.IUserService;

/**
 *类的作用：userService的junit测试
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-28   下午2:47:58
 */
public class UserServiceTest extends BaseServiceTest {
	@Autowired
	IUserService userService;

	@Test
	public void testSave() throws Exception {
		User user1 = new User("无悔", "wuhui@163.com", "wuhui");
		user1.setPassword("wuhui");
		
		User user2 = new User("一叶扁舟", "yiyepianzhou@163.com", "yiyepianzhou");
		user2.setPassword("yiyepianzhou");
		
		userService.save(user1);
		userService.save(user2);
	}
}
