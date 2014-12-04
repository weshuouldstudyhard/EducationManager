package  cn.edu.fjnu.cdio4.xplan.page;

import cn.edu.fjnu.cdio4.xplan.domain.Reply;
import cn.edu.fjnu.cdio4.xplan.domain.Topic;


/**
 *类的作用：模板 Query
 *查询对象:封装Reply的查询条件(名称),还必须有当前页码,一页条数(由父类处理)

 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-12-3   上午9:00:08
 */
public class ReplyQuery extends BaseQuery {
	private String title;
	private Topic topic;
	private Reply reply;
	

	public ReplyQuery() {
		super("Reply");
	}

	@Override
	protected void addWhere() {
		if (topic !=null) {
			System.out.println("topic.getId():"+topic.getId());
			addWhere(" o.topic.id = ?",topic.getId());
		}
	}

	
	
	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	

}
