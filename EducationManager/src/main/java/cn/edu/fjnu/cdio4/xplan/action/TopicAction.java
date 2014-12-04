package cn.edu.fjnu.cdio4.xplan.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.From;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.fjnu.cdio4.xplan.domain.Forum;
import cn.edu.fjnu.cdio4.xplan.domain.Reply;
import cn.edu.fjnu.cdio4.xplan.domain.Topic;
import cn.edu.fjnu.cdio4.xplan.domain.User;
import cn.edu.fjnu.cdio4.xplan.page.PageResult;
import cn.edu.fjnu.cdio4.xplan.page.ReplyQuery;
import cn.edu.fjnu.cdio4.xplan.page.TopicQuery;
import cn.edu.fjnu.cdio4.xplan.service.IForumService;
import cn.edu.fjnu.cdio4.xplan.service.IReplyService;
import cn.edu.fjnu.cdio4.xplan.service.ITopicService;
import cn.edu.fjnu.cdio4.xplan.service.impl.ForumServiceImpl;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * 类的作用：话题(主贴)的逻辑处理完后进行页面分配的处理
 * 
 * 
 * @author 一叶扁舟
 * @version 1.0
 * @创建时间： 2014-11-30 下午6:32:46
 */
public class TopicAction extends CRUDAction<Topic> {
	private ITopicService topicService;
	private IReplyService replyService;
	private PageResult<Reply> pageResult;
	private IForumService forumService;
	private ReplyQuery baseQuery = new ReplyQuery();
	private List<Topic> topics = new ArrayList<Topic>();
	private Topic topic;
	// 获取从forum传过来的forumId
	private Long forumId;
	private String title;
	private String content;
	private Long id;
	private Reply reply;
	private List<Reply> replies = new ArrayList<Reply>();

	/**
	 * 
	 * 列出一个主题下的所有的回复
	 * 
	 * */
	@InputConfig(methodName = "showTopic")
	public String showTopic() {
		Topic topic;
		if (id == null) {
			topic = (Topic) getSession("topic");
		} else {
			/* 根据id从数据库中查出对应的这个版块信息 */
			topic = topicService.get(id);
		}
		/* 将版块放入到作用域中 */
		// putContext("topic", topic);
		putSession("topic", topic);
		System.out.println("TopicAction:topic:" + topic);

		// 根据topicId,到reply表中查询这个主题下的所有的回复
		// topic = new Topic(id);
		replies = replyService.finRepliesByTopic(topic);
		// 将这个主题下的所有的回复放入到作用域中
		putContext("allReplies", replies);
		// baseQuery.setTopic(topic);
		// baseQuery.setReply(reply);
		// baseQuery.setTitle(topic.getTitle());
		// StringBuilder hqlBuilder = new
		// StringBuilder("SELECT o FROM Reply o WHERE  o.topic =  ?");
		// baseQuery.setHql(hqlBuilder);
		//

		// 根据帖子的编号查询出所有的回复
		baseQuery.setTopic(topic);
		this.pageResult = replyService.findPageResult(baseQuery);
		// this.pageResult.s
		return "showTopic";
	}

	/**
	 * 从forumAction中获取forumId，然后从数据库中获取这个forum，放入到作用域中 跳转到添加topic中
	 */
	public String addTopic() {
		/* 从数据库中查出对应的这个版块 */
		Forum forum = null;
		if (id != null) {
			forum = forumService.get(id);
		} else {
			forum = (Forum) getSession("forum");

		}
		/* 将版块放入到作用域中 */
		putSession("forum", forum);
		// putContext("forum", forum);
		return "addTopic";

	}

	/**
	 * 添加一个新的主贴
	 */
	public String add() {
		/* 获取数据，然后将数据放入到domain中 */
		// 可以从系统中获取
		// id = forumId;
		Topic topic = new Topic(id);
		User user = getLoginUser();
		System.out.println("getLoginUser:" + getLoginUser());
		topic.setUser(getLoginUser());
		System.out.println("forum:" + (Forum) getSession("forum"));
		topic.setForum((Forum) getSession("forum"));
		topic.setIpAddr(request.getRemoteAddr());
		topic.setPostTime(new Date());

		// 之后的设置
		// topic.setLastReply(lastReply);
		// topic.setLastUpdateTime(lastUpdateTime);
		// topic.setReplies(replies);
		// topic.setReplyCount(replyCount);
		// 默认为普通帖子
		topic.setType(0);

		// 从输入框中获取
		topic.setTitle(title);
		topic.setContent(content);

		// 保存到数据库中
		topicService.save(topic);
		return "reload";

	}

	@Override
	protected void list() throws Exception {
		logger.debug("list");
		// 添加一个xx的查询列表
		// putContext("allDepts", departmentService.getAll());
		// putContext("topic", topicService.get(id));
		this.pageResult = replyService.findPageResult(baseQuery);

	}

	@Override
	public String input() throws Exception {
		logger.debug("input");
		// 添加一个xx的选择列表
		// putContext("allDepts", departmentService.getAll());
		return INPUT;
	}

	@Override
	// 保存的时候:如果出现转换异常:把字符串放到了Integer属性里面 ,默认会跳转到input指向的jsp页面
	@InputConfig(methodName = "input")
	public String save() throws Exception {
		logger.debug("save");

		if (id == null) {
			topicService.save(topic);
		} else {
			topicService.update(topic);
		}
		addActionMessage("保存成功");
		return RELOAD;
	}

	// ajax删除
	@Override
	public String delete() throws Exception {
		logger.debug("delete");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (id != null) {
				topicService.delete(id);
				out.print("{\"success\":true,\"msg\":\"删除成功\"}");
				// addActionMessage("删除成功");不能,ajax删除是不能通过addActionMessage方法消息
			} else {
				out.print("{\"success\":false,\"msg\":\"不能获取到id的值\"}");
			}
		} catch (Exception e) {
			out.print("{\"success\":false,\"msg\":\"" + e.getMessage() + "\"}");
		}
		return null;
	}

	@Override
	protected void beforeInput() throws Exception {
		logger.debug("beforeInput");
		if (id != null) {
			topic = topicService.get(id);// 回显
		}
	}

	@Override
	protected void beforeSave() throws Exception {
		logger.debug("beforeSave");
		if (id == null) {
			topic = new Topic();
		} else {
			// topic持久状态
			topic = topicService.get(id);// 把数据从数据库加载出来,没有在jsp页面出现的属性不会丢失
		}
	}

	/******* 所有的set和get方法 *********/

	public IForumService getForumService() {
		return forumService;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public void setForumService(IForumService forumService) {
		this.forumService = forumService;
	}

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	public PageResult<Reply> getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult<Reply> pageResult) {
		this.pageResult = pageResult;
	}

	public ReplyQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(ReplyQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public IReplyService getReplyService() {
		return replyService;
	}

	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}

	public Topic getModel() {
		return topic;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setReplyService(IReplyService replyService) {
		this.replyService = replyService;
	}

}
