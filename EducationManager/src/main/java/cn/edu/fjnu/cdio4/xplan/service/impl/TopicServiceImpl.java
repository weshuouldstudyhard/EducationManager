package  cn.edu.fjnu.cdio4.xplan.service.impl;

import java.util.List;

import cn.edu.fjnu.cdio4.xplan.domain.Forum;
import cn.edu.fjnu.cdio4.xplan.domain.Topic;
import cn.edu.fjnu.cdio4.xplan.service.ITopicService;

/**
 *类的作用：话题(帖子)的实现类
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-30   下午6:26:58
 */
public class TopicServiceImpl extends BaseServiceImpl<Topic> implements ITopicService {

	/* (non-Javadoc)
	 * @see cn.edu.fjnu.cdio4.xplan.service.ITopicService#findTopicByForum(java.lang.Long)
	 */
	public List<Topic> findTopicByForum(Forum forum) {
		String hql = "select t from Topic t where t.forum =?";
		List<Topic> topics = findByHql(hql, forum);
		System.out.println(topics.toString());
		return topics;
	}

}
