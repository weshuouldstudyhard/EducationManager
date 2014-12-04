package cn.edu.fjnu.cdio4.xplan.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-30   下午12:41:37
 */
public class Topic extends Article{

	/** 普通帖 */
	public static final int TYPE_NORMAL = 0;

	/** 精华帖 */
	public static final int TYPE_BEST = 1;

	/** 置顶帖 */
	public static final int TYPE_TOP = 2;

	/*所属版块:c++,java,数据结构*/
	private Forum forum;
	/*一个主贴子对应下很多个回复的帖子*/
	private Set<Reply> replies = new HashSet<Reply>();

	/*类型:精华帖，置顶帖，普通帖*/
	private int type;
	/*回复数量*/
	private int replyCount; 
	/*最后回复信息*/
	private Reply lastReply;
	/*最后更新时间（主题发表时间或最后回复的时间）*/
	private Date lastUpdateTime;
	
	
	/**
	 * 
	 */
	public Topic() {
		super();
	}
	/**
	 * @param id 
	 * 
	 */
	public Topic(Long id) {
		super(id);
	}
	/**
	 * @param forum
	 * @param replies
	 * @param type
	 * @param replyCount
	 * @param lastReply
	 * @param lastUpdateTime
	 */
	public Topic(Forum forum, Set<Reply> replies, int type, int replyCount,
			Reply lastReply, Date lastUpdateTime) {
		super();
		this.forum = forum;
		this.replies = replies;
		this.type = type;
		this.replyCount = replyCount;
		this.lastReply = lastReply;
		this.lastUpdateTime = lastUpdateTime;
	}
	

	
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public Reply getLastReply() {
		return lastReply;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	

}
