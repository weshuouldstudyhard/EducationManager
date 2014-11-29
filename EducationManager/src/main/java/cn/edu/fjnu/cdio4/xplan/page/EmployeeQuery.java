package cn.edu.fjnu.cdio4.xplan.page;

import org.apache.commons.lang3.StringUtils;



/**
 *类的作用：查询对象:封装Employee的查询条件(名称),还必须有当前页码,一页条数(由父类处理)
 *如果是多条件查询的话，这个字段查询的是name，还可以是age,email，等字段，都可以将要查询的东西放入到这个里面
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-13   上午12:02:18
 */
public class EmployeeQuery extends BaseQuery {
	private String name;

	public EmployeeQuery() {
		super("Employee");
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
