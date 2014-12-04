package cn.edu.fjnu.cdio4.xplan.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.fjnu.cdio4.xplan.domain.Forum;
import cn.edu.fjnu.cdio4.xplan.domain.Topic;
import cn.edu.fjnu.cdio4.xplan.page.ForumQuery;
import cn.edu.fjnu.cdio4.xplan.page.PageResult;
import cn.edu.fjnu.cdio4.xplan.page.TopicQuery;
import cn.edu.fjnu.cdio4.xplan.service.IForumService;
import cn.edu.fjnu.cdio4.xplan.service.ITopicService;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * 类的作用：论坛版块的action
 * 
 * 
 * @author 一叶扁舟
 * @version 1.0
 * @创建时间： 2014-11-30 下午1:13:32
 */
public class ForumAction extends CRUDAction<Forum> {
	private IForumService forumService;
	private PageResult<Topic> pageResult;
	private ITopicService topicService;
	private TopicQuery baseQuery = new TopicQuery();
	private List<Forum> forums = new ArrayList<Forum>();
	private List<Topic> topics = new ArrayList<Topic>();
	private Forum forum;

	public ITopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<Forum> getForums() {
		return forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}

	public TopicQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(TopicQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public PageResult<Topic> getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult<Topic> pageResult) {
		this.pageResult = pageResult;
	}

	public void setForumService(IForumService forumService) {
		this.forumService = forumService;
	}

	public Forum getModel() {
		return forum;
	}

	@Override
	protected void list() throws Exception {
		logger.debug("list");
		// 添加一个xx的查询列表
		// putContext("allDepts", departmentService.getAll());
		// 获取版块中的所有数据
		this.forums = forumService.getAll();
		putSession("allForums", forums);
		System.out.println("forums:" + forums);

		// 查询出一个版块下的所有的topic,并封装到pageresult中
		this.pageResult = topicService.findPageResult(baseQuery);
	}

	/*
	 * 显示一个版块下的所有的帖子
	 */
	public String showForum() {
		Forum forum;
		if (id == null) {
			forum = (Forum) getSession("forum");
		} else {
			/* 根据id从数据库中查出对应的这个版块信息 */
			forum = forumService.get(id);
		}
		/* 将版块放入到作用域中 */
		putSession("forum", forum);
		System.out.println("ForumAction:forum:" + forum);

		baseQuery.setForum(forum);
		this.pageResult = topicService.findPageResult(baseQuery);
		/* 取出这个版块的所有主题 */
		topics = topicService.findTopicByForum(forum);
//		putContext("allTopics", topics);
		return "showForum";
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
			forumService.save(forum);
		} else {
			forumService.update(forum);
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
				forumService.delete(id);
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
			forum = forumService.get(id);// 回显
		}
	}

	@Override
	protected void beforeSave() throws Exception {
		logger.debug("beforeSave");
		if (id == null) {
			forum = new Forum();
		} else {
			// forum持久状态
			forum = forumService.get(id);// 把数据从数据库加载出来,没有在jsp页面出现的属性不会丢失
		}
	}

}
