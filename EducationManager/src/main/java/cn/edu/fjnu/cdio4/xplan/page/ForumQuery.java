package  cn.edu.fjnu.cdio4.xplan.page;

import org.apache.commons.lang3.StringUtils;


/**
 *类的作用：Query
 *查询对象:封装Forum的查询条件(名称),还必须有当前页码,一页条数(由父类处理)
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-30   下午1:10:51
 */
public class ForumQuery extends BaseQuery {
	private String name;

	public ForumQuery() {
		super("Forum");
	}

	@Override
	protected void addWhere() {
		if (StringUtils.isNotBlank(name)) {
			addWhere("o.name LIKE ?", "%" + name + "%");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
