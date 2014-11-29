package cn.edu.fjnu.cdio4.xplan.service;

import java.io.Serializable;
import java.util.List;

import cn.edu.fjnu.cdio4.xplan.page.BaseQuery;
import cn.edu.fjnu.cdio4.xplan.page.PageResult;


/**
 *类的作用：service的顶级接口
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-12   下午05:08:22
 */
public interface IBaseService<T> {
	void save(T t);

	void update(T t);

	//传入的产生只要是实现serializable接口就行了，比如传入String，int,long 都可以复用
	void delete(Serializable id);

	T get(Serializable id);

	List<T> getAll();

	PageResult<T> findPageResult(BaseQuery baseQuery);

	List findByHql(String hql, Object... objects);

}
