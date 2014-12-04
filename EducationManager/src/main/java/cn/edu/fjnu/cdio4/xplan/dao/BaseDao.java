package cn.edu.fjnu.cdio4.xplan.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.fjnu.cdio4.xplan.page.BaseQuery;
import cn.edu.fjnu.cdio4.xplan.page.PageResult;



/**
 *类的作用：dao的基础类，用于最直接的与数据库交互
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-10   下午02:50:05
 */
public class BaseDao<T> extends HibernateDaoSupport {

	// 将数据添加到数据库中
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	/**
	 * 删除数据
	 * 
	 * @param entityClass
	 *            要删除的那个实体类
	 * @param id
	 *            实体的主键，这个主键可能是Stirng,int,long类型， 用Serializable类保存其通用性）
	 */
	public void delete(Class<T> entityClass, Serializable id) {
		// 如果不进行判断的话，getHibernateTemplate().delete(id);报错
		T t = this.get(entityClass, id);
		if (t != null) {
			getHibernateTemplate().delete(t);
		}

	}

	/**
	 * 修改
	 * 
	 * @param t
	 */
	public void update(T t) {
		getHibernateTemplate().update(t);

	}

	/**
	 * @param entityClass
	 *            实体
	 * @param id
	 *            主键
	 * @return 数据库中对应的实体
	 */
	public T get(Class<T> entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	// 获取系统中所有的数据
	public List<T> getAll(Class<T> entityClass) {
		/*
		 * entityClass.getName():获取的是全限定名:cn.edu.fjnu.cdio4.xplan.domain.Employee
		 * entityClass.getSimpleName();获取的是类名:Employee
		 * 
		 */
		System.out.println("entityClass："+ entityClass.getName()+"--->"+entityClass.getSimpleName());
		return getHibernateTemplate().find("FROM " + entityClass.getSimpleName());

	}
	
	//得到分页的查询结果
	public PageResult<T> findPageResult(final BaseQuery baseQuery) {
		System.out.println("findPageResult countHql:" + baseQuery.getCountHql());
		System.out.println("findPageResult hql:" + baseQuery.getHql());
		System.out.println("findPageResult paramList:" + baseQuery.getParamList());
		/**
		 * NativeSession：用到本地的session,用new 出接口，然后在接口中写匿名内部类的方式，写实现
		 * 
		 */

		int count = getHibernateTemplate().executeWithNativeSession(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				// 发出countHql
				Query query = session.createQuery(baseQuery.getCountHql());
				// 设置参数
				int index = 0;
				for (Object object : baseQuery.getParamList()) {
					//逐条的设置参数
					query.setParameter(index++, object);
				} 
				Long countLong = (Long) query.uniqueResult();
				return countLong.intValue();
			}
		});
		// 没有查询到数据
		if (count == 0) {
			return new PageResult<T>();
		}
		/*
		 * 创建一个PageResult对象，设置三个参数：当前页，每页的大小，和记录数
		 * 定义成final，只是里面的地址固定了，但是里面的内容还是可以改的
		 */
		
		final PageResult<T> pageResult = new PageResult<T>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), count);
		// 当前页的数据
		List<T> rows = getHibernateTemplate().executeWithNativeSession(new HibernateCallback<List<T>>() {
			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				// 发出hql
				Query query = session.createQuery(baseQuery.getHql());
				// 设置参数
				int index = 0;
				for (Object object : baseQuery.getParamList()) {
					query.setParameter(index++, object);
				}
				// 设置分页条件
				// baseQuery对象里面的CurrentPage,PageSize没有经过错误处理,必须使用pageResult对象
				int first = (pageResult.getCurrentPage() - 1) * pageResult.getPageSize();
				int max = pageResult.getPageSize();
				System.out.println("first:" + first + ",max:" + max);
				//进入到数据库中查询，查询出分页的数据
				query.setFirstResult(first).setMaxResults(max);
				return query.list();
			}
		});
		pageResult.setRows(rows);
		return pageResult;
	}
	
	

	/**
	 * 
	 * @param hql 可以写各种hql语句，也可以是sql语句，（hql语句是hibernate的查询语句，和sql语句很多也类似）
	 * 
	 * @param objects 参数，sql/hql语句的参数
	 * @return  直接放回List,没有T
	 */
	public List findByHql(String hql, Object... objects) {
		System.out.println("hql:"+hql+"objects:"+objects);
		return getHibernateTemplate().find(hql, objects);
	}


}
