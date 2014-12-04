package  cn.edu.fjnu.cdio4.xplan.service.impl;

import java.util.Date;
import java.util.List;

import cn.edu.fjnu.cdio4.xplan.domain.Reply;
import cn.edu.fjnu.cdio4.xplan.domain.Topic;
import cn.edu.fjnu.cdio4.xplan.domain.User;
import cn.edu.fjnu.cdio4.xplan.page.BaseQuery;
import cn.edu.fjnu.cdio4.xplan.page.PageResult;
import cn.edu.fjnu.cdio4.xplan.service.IReplyService;

/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-12-3   上午8:59:41
 */
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements IReplyService {

	/* (non-Javadoc)
	 * @see cn.edu.fjnu.cdio4.xplan.service.IReplyService#finRepliesByTopic(cn.edu.fjnu.cdio4.xplan.domain.Topic)
	 */
	public List<Reply> finRepliesByTopic(Topic topic) {
		String hql ="From Reply r where r.topic = ?";
		List<Reply> replies = findByHql(hql, topic);
		System.out.println(topic+"下的所有的回复：\n"+replies);
		return replies;
	}


	/* (non-Javadoc)
	 * @see cn.edu.fjnu.cdio4.xplan.service.IReplyService#findReply(java.lang.String, java.lang.String, java.util.Date, cn.edu.fjnu.cdio4.xplan.domain.User, cn.edu.fjnu.cdio4.xplan.domain.Topic)
	 */
	public Reply findReply(String title, String content, Date postTime,
			User user, Topic topic) {
		String hql ="From Reply r where r.title = ? and r.content = ? and" +
				" r.postTime = ? and r.user = ? and r.topic = ?";
		List<Reply> replies = findByHql(hql, title,content,postTime,user,topic);
		Reply reply = replies.get(0);
		return reply;
	}

/*
	覆写分页查询的方法
	public PageResult<Reply> findPageResult(Topic topic) {
		
		PageResult<Reply> pageResult = null;
		//查询出总共的页数
		String countHql = "SELECT COUNT(o) FROM Reply o WHERE o.topic =  ? ";
		String  hql = "SELECT o FROM Reply o WHERE  o.topic =  ?";
		
		List<Reply> rows = findByHql(hql, topic);
		//设置查询结构
		pageResult.setRows(rows);
		int totalCount = (Integer) findByHql(countHql, topic).get(0);
		pageResult.setTotalCount(totalCount);
		
		
		
		// TODO Auto-generated method stub
		return pageResult;
	}
	
	
	
	*/

}
