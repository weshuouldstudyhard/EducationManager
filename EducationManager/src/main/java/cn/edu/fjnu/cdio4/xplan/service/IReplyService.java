package  cn.edu.fjnu.cdio4.xplan.service;

import java.util.Date;
import java.util.List;

import cn.edu.fjnu.cdio4.xplan.domain.Reply;
import cn.edu.fjnu.cdio4.xplan.domain.Topic;
import cn.edu.fjnu.cdio4.xplan.domain.User;
import cn.edu.fjnu.cdio4.xplan.page.PageResult;

/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-12-3   上午8:59:31
 */
public interface IReplyService extends IBaseService<Reply> {

	/**
	 * 
	 * 根据传入进来的topicId进行查询出这个主贴下的所有的回复
	 * @param topic
	 * @return
	 */
	List<Reply> finRepliesByTopic(Topic topic);

	/**
	 * @param title
	 * @param content
	 * @param postTime
	 * @param user
	 * @param topic
	 * @return
	 */
	Reply findReply(String title, String content, Date postTime, User user,
			Topic topic);

}
