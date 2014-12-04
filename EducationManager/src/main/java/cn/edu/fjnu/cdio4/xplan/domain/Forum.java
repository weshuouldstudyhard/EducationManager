package cn.edu.fjnu.cdio4.xplan.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-30   下午12:36:03
 */
public class Forum  implements Serializable{
	private Long id;
	private String name;    //版块的名字
	private String description;//版块的描述
	private int position; // 排序用的位置号
	private  String firstIconPath;  //版块的前置图片
	private  String  lastIconPath;  //版块的后置图片
//	private Set<Topic> topics = new HashSet<Topic>();
	/**
	 * 
	 */
	public Forum() {
		super();
	}
	/**
	 * @param id
	 */
	public Forum(Long id) {
		this.id = id;
	}
	/**
	 * @param name
	 * @param description
	 * @param position
	 * @param firstIconPath
	 * @param lastIconPath
	 * @param topics
	 */
	public Forum(String name, String description, int position,
			String firstIconPath, String lastIconPath) {
		super();
		this.name = name;
		this.description = description;
		this.position = position;
		this.firstIconPath = firstIconPath;
		this.lastIconPath = lastIconPath;
//		this.topics = topics;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getFirstIconPath() {
		return firstIconPath;
	}
	public void setFirstIconPath(String firstIconPath) {
		this.firstIconPath = firstIconPath;
	}
	public String getLastIconPath() {
		return lastIconPath;
	}
	public void setLastIconPath(String lastIconPath) {
		this.lastIconPath = lastIconPath;
	}
	/*public Set<Topic> getTopics() {
		return topics;
	}
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}*/
	
	/**
	 * 覆写toString方法，不能写出集合中的数据或者会出现错误！
	 */
	@Override
	public String toString() {
		return "Forum [id=" + id + ", name=" + name + ", description="
				+ description + ", position=" + position + ", firstIconPath="
				+ firstIconPath + ", lastIconPath=" + lastIconPath + "]";
	}

}
