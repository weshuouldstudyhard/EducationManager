package cn.edu.fjnu.cdio4.xplan.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import cn.edu.fjnu.cdio4.xplan.dao.BaseDao;
import cn.edu.fjnu.cdio4.xplan.page.BaseQuery;
import cn.edu.fjnu.cdio4.xplan.page.PageResult;
import cn.edu.fjnu.cdio4.xplan.service.IBaseService;


/**
 *类的作用：实现顶级接口的抽象类，这个抽象类是基类，自己定义的service必须继承这个BaseServiceImpl，
 *如果有些方法其他的service都需要，那么就可以扩展BaseServiceImpl,让所有的额子类都可以复用，
 *同时访问数据库，也是在这一层访问的
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-12   下午05:11:21
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {
	private BaseDao<T> baseDao;
	private Class<T> entityClass;

	public BaseServiceImpl() {
		//利用反射的知识，获取当前类的字节码
		Class clazz = getClass();
		// System.out.println("getClass():" + clazz);// EmployeeServiceImpl
		Type type = clazz.getGenericSuperclass();
		// System.out.println("getGenericSuperclass():" + type);//
		// BaseServiceImpl<Employee>
		//判断type是否是参数化类型，即泛型类型
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			//即获取参数化类型的参数
			entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		}
		System.out.println("entityClass:" + entityClass);// Employee.class
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	public void save(T t) {
		baseDao.save(t);
	}

	public void update(T t) {
		baseDao.update(t);
	}

	public void delete(Serializable id) {
		baseDao.delete(entityClass, id);
	}

	public T get(Serializable id) {
		return baseDao.get(entityClass, id);
	}

	public List<T> getAll() {
		return baseDao.getAll(entityClass);
	}

	//分页查询
	public PageResult<T> findPageResult(BaseQuery baseQuery) {
		return baseDao.findPageResult(baseQuery);
	}

	//这个是万能的查询的接口，可以在这个方法中写自己的查询语句
	public List findByHql(String hql, Object... objects) {
		return baseDao.findByHql(hql, objects);
	}


}
