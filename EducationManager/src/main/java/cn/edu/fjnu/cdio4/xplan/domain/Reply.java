package cn.edu.fjnu.cdio4.xplan.domain;

/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-30   下午5:54:50
 */
public class Reply extends Article{
	private Topic topic;// 所属的主题

	
	public Reply() {
		super();
	}
	
	
	
	
	public Reply(Long id) {
		super();
	}


	public Topic getTopic() {
		return topic;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	@Override
	public String toString() {
		return "Reply [topic=" + topic + "]";
	}

}
