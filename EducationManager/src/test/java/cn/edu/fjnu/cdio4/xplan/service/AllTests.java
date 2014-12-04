package cn.edu.fjnu.cdio4.xplan.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 *类的作用：放前面(单表)先运行,依赖的测试放后面
 * 运行这个一次可以将所有的表都能搞定，所以特别要注意这个放置的顺序
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-30   下午8:30:16
 */
@RunWith(Suite.class)
@SuiteClasses({ UserServiceTest.class ,EmployeeServiceTest.class,
	            ForumServiceTest.class, TopicServiceTest.class,
	            ReplyServiceTest.class})
public class AllTests {

}
