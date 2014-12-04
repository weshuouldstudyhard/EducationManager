package  cn.edu.fjnu.cdio4.xplan.action;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.fjnu.cdio4.xplan.domain.Forum;
import cn.edu.fjnu.cdio4.xplan.domain.Reply;
import cn.edu.fjnu.cdio4.xplan.domain.Topic;
import cn.edu.fjnu.cdio4.xplan.domain.User;
import cn.edu.fjnu.cdio4.xplan.page.PageResult;
import cn.edu.fjnu.cdio4.xplan.page.ReplyQuery;
import cn.edu.fjnu.cdio4.xplan.service.IReplyService;
import cn.edu.fjnu.cdio4.xplan.service.ITopicService;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;


/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-12-3   上午9:00:40
 */
public class ReplyAction extends CRUDAction<Reply> {
	private IReplyService replyService;
	private ITopicService topicService;
	private PageResult<Reply> pageResult;
	private ReplyQuery baseQuery = new ReplyQuery();
	private Reply reply;
	private Topic topic;
	private User user;
	private String content;
	private String title;
	
	
	
	/*添加一个回复*/
	
	
	public String addReply(){
		/*从数据库中查出对应的这个版块*/
		Topic topic = null;
		if(id != null){
			topic = topicService.get(id);
			putSession("topic", topic);
		}else{
			topic = (Topic) getSession("topic");
			
		}
		/*将主题放入到作用域中*/
//		putContext("topic", topic);
		putSession("topic", topic);
		return "addReply";
	}
	
	
	
	/*添加一个回复*/

	public String add(){
		Topic topic = null;
	    if(id!= null){
	    	topic = topicService.get(id);
	    	putSession("topic",topic);
	    	System.out.println("------------------");
	    }else{
	    	/**从作用域中取出对应的这个主题**/
	    	topic = (Topic) getSession("topic");
	    	System.out.println("=================");
	    }
	    
	    if(title == null){
	    	title = topic.getTitle();
	    }
	    
	    
//		System.out.println("ReplyAction:topic:"+topic);
//		System.out.println("getContext('topic'):"+getContext("topic"));
//		System.out.println("request.getAttribute('topic')："+request.getAttribute("topic"));
		/*从作用域中取出登录的用户*/
		user = (User) getSession("user");
		reply = new Reply();
		
		/*这个回复的内容是从jsp中用户输入传进来的值*/
		reply.setContent(content);
		reply.setIpAddr(request.getRemoteAddr());
		reply.setPostTime(new Date());
		reply.setTitle(title);
		reply.setUser(user);
		reply.setTopic(topic);
		
		//在保存到topic之前，这个reply应该是存在数据库中的，因为topic引用的是
		//reply的主键，然而在为保存到数据库之前，reply是没有主键的
		
		System.out.println("replyAction:add:"+user);
		System.out.println("replyAction:topic:"+topic);
		System.out.println("replyAction:reply:"+reply.toString());
		//将reply保存到数据库中
		replyService.save(reply);
		//再从数据库中取出这个数据(带主键的)
		reply = replyService.findReply(reply.getTitle(),content,reply.getPostTime(),user,topic);
		
		topic.setLastReply(reply);
		topic.setLastUpdateTime(new Date());
		topic.setReplyCount(topic.getReplyCount()+1);
		
		
		//更新数据库中的topic
		topicService.update(topic);
		//将最新的topic放到作用域中
		putSession("topic", topic);
	
		return "showTopic";
	}
	

	@Override
	protected void list() throws Exception {
		logger.debug("list");
		// 添加一个xx的查询列表
//		putContext("allDepts", departmentService.getAll());
		this.pageResult = replyService.findPageResult(baseQuery);
	}

	@Override
	public String input() throws Exception {
		logger.debug("input");
		// 添加一个xx的选择列表
//		putContext("allDepts", departmentService.getAll());
		return INPUT;
	}

	@Override
	// 保存的时候:如果出现转换异常:把字符串放到了Integer属性里面 ,默认会跳转到input指向的jsp页面
	@InputConfig(methodName = "input")
	public String save() throws Exception {
		logger.debug("save");
		
		if (id == null) {
			replyService.save(reply);
		} else {
			replyService.update(reply);
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
				replyService.delete(id);
				out.print("{\"success\":true,\"msg\":\"删除成功\"}");
				// addActionMessage("删除成功");不能,ajax删除是不能通过addActionMessage方法消息
			} else {
				out.print("{\"success\":false,\"msg\":\"不能获取到id的值\"}");
			}
		} catch (Exception e) {
			out.print("{\"success\":false,\"msg\":\""+e.getMessage()+"\"}");
		}
		return null;
	}

	@Override
	protected void beforeInput() throws Exception {
		logger.debug("beforeInput");
		if (id != null) {
			reply = replyService.get(id);// 回显
		}
	}

	@Override
	protected void beforeSave() throws Exception {
		logger.debug("beforeSave");
		if (id == null) {
			reply = new Reply();
		} else {
			// reply持久状态
			reply = replyService.get(id);// 把数据从数据库加载出来,没有在jsp页面出现的属性不会丢失
		}
	}	
	
	/**************setter和getter方法******************************/

	
	
	
	
	public ReplyQuery getBaseQuery() {
		return baseQuery;
	}

	public Topic getTopic() {
		return topic;
	}



	public void setTopic(Topic topic) {
		this.topic = topic;
	}



	public void setPageResult(PageResult<Reply> pageResult) {
		this.pageResult = pageResult;
	}



	public ITopicService getTopicService() {
		return topicService;
	}



	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
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


	public Reply getReply() {
		return reply;
	}


	public void setReply(Reply reply) {
		this.reply = reply;
	}


	public void setBaseQuery(ReplyQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public PageResult<Reply> getPageResult() {
		return pageResult;
	}

	public void setReplyService(IReplyService replyService) {
		this.replyService = replyService;
	}

	public Reply getModel() {
		return reply;
	}


}
