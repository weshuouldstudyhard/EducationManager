package  cn.edu.fjnu.cdio4.xplan.page;

import org.apache.commons.lang3.StringUtils;

import cn.edu.fjnu.cdio4.xplan.domain.Forum;


/**
 *类的作用：
 *查询对象:封装Topic的查询条件(名称),还必须有当前页码,一页条数(由父类处理)

 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-30   下午6:32:07
 */
public class TopicQuery extends BaseQuery {
	private String title;
	private Forum forum;

	public TopicQuery() {
		super("Topic");
	}

	@Override
	protected void addWhere() {
		if (forum != null) {
			addWhere("o.forum.id  = ? order by postTime desc", forum.getId());
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Forum getForum() {
		return forum;
	}

}
