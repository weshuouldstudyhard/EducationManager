package cn.edu.fjnu.cdio4.xplan.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.fjnu.cdio4.xplan.domain.LoginUser;


/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-13   上午01:55:43
 */
public class LoginUserTest extends BaseServiceTest {
	
	
	@Autowired
	ILoginUserService loginUserService;
	
	@Test
	public void saveTest() {

		LoginUser user = new LoginUser();
		user.setId(1L);
		user.setUserName("admin");
		user.setPassword("admin");
		
		
		LoginUser user2 = new LoginUser();
		user2.setId(2L);
		user2.setUserName("一叶扁舟");
		user2.setPassword("一叶扁舟");
		
		loginUserService.save(user);
		loginUserService.save(user2);

	}

}
