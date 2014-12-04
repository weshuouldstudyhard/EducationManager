package cn.edu.fjnu.cdio4.xplan.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.fjnu.cdio4.xplan.domain.Forum;
import cn.edu.fjnu.cdio4.xplan.service.IForumService;

/**
 *类的作用：论坛版块的测试
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-30   下午1:12:15
 */
public class ForumServiceTest extends BaseServiceTest {
	@Autowired
	IForumService forumService;

	@Test
	public void testSave() throws Exception {
		Forum forum = new Forum("c++", "c++论坛版块", 1, "images/major01.png", "images/major_back01.png");
		Forum forum2 = new Forum("数据结构", "数据结构论坛版块", 2, "images/major02.png", "images/major_back02.png");
		Forum forum3= new Forum("java", "java论坛版块", 3, "images/major03.png", "images/major_back03.png");
		
		
		forumService.save(forum); 
		forumService.save(forum2);
		forumService.save(forum3);
	}
}
