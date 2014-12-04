package  cn.edu.fjnu.cdio4.xplan.service;

import java.util.List;

import cn.edu.fjnu.cdio4.xplan.domain.Forum;
import cn.edu.fjnu.cdio4.xplan.domain.Topic;

/**
 *类的作用：话题(帖子)的接口
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-30   下午6:26:22
 */
public interface ITopicService extends IBaseService<Topic> {

	/**
	 * 根据版块的id，查询出这个版块对应的所有帖子
	 * @param forum
	 * @return
	 */
	List<Topic> findTopicByForum(Forum forum);

}
