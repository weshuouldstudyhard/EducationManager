package cn.edu.fjnu.cdio4.xplan.domain;

import java.util.Date;



/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-30   下午5:56:42
 */
public class Article {
	private Long id;
	//标题
	private String title; // 标题
	private String content;// 内容
	private User user;// 作者
	private Date postTime;// 发表时间
	private String ipAddr;// 发表文章时所用的IP地址
	public Article() {
	}
	/**
	 * @param id
	 */
	public Article(Long id) {
		super();
		this.id = id;
	}
	/**
	 * @param title
	 * @param content
	 * @param author
	 * @param postTime
	 * @param ipAddr
	 */
	public Article(String title, String content, User user, Date postTime,
			String ipAddr) {
		super();
		this.title = title;
		this.content = content;
		this.user = user;
		this.postTime = postTime;
		this.ipAddr = ipAddr;
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	
	
	


}
