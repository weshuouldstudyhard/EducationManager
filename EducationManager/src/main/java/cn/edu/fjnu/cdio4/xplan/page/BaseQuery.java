package cn.edu.fjnu.cdio4.xplan.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


/**
 *类的作用：查询对象:封装公共当前页码,一页条数,封装2条hql以及参数值
 *这类不能直接用，这个是父类，子类进行继承调用
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-11   下午08:27:17
 */
public abstract class BaseQuery {
	
	/* hql:select o from Employee o where o.name like ? and o.email like ? and
	   o.department.id=?
	  没用同步的需求都用StringBuilder封装，而且StringBuilder的性能高些
	  查询出满足所有条件的数据
	*/
	private StringBuilder hql;

	/*拼接的SQL语句: countHql:select count(o) from Employee o where o.name like ? and o.email
	 like ? and o.department.id=?
     获取所有的条目数
	*/
	private StringBuilder countHql;
	//一个标志，判断是否已经拼接了SQL语句
	private boolean flag ;
	

	// 添加参数值，用来存储所有的参数，就是查询的条件，用list的好处：是有序，并且不用初始化大小
	private List paramList = new ArrayList();
	// 封装公共当前页码
	private int currentPage = 1;
	//每页的记录数
	private int pageSize = 10;
	

	//从子类 传进来的参数，子类的要查询的数据库表
	public BaseQuery(String className) {
		hql = new StringBuilder("SELECT o FROM " + className + " o");
		countHql = new StringBuilder("SELECT COUNT(o) FROM " + className + " o");
	}
	/*
	 * 添加一个让子类处理查询提交的方法
	 * 注意修饰符是:protected,让子类可以访问父类的方法
	 */
	protected abstract void addWhere();

	// 添加一个方法:直接让子类传入查询的条件和参数值
	// select o from Domain o where o.date between ? and ?
	protected void addWhere(String where, Object... objects) {
		// 是用where还是and，如果第一次传入条件，则用where拼接，之后的用and拼接，
		if (paramList.size() == 0) {
			hql.append(" WHERE ").append(where);
			countHql.append(" WHERE ").append(where);
		} else {
			hql.append(" AND ").append(where);
			countHql.append(" AND ").append(where);
		}
		// 设置参数:1.addAll方法,2.把objects数组变成List
		paramList.addAll(Arrays.asList(objects));
	}

	private void builderWhere() {
//		用flag保证addWhere()只能调用一次
		if (!flag) {
			addWhere();
			flag = true;
		}
	}

	// 因为BaseDao必须能够获取到hql,countHql,paramList
	public String getHql() {
		builderWhere();
		return hql.toString();
	}

	//拼接查询语句:获取总的记录数
	public String getCountHql() {
		builderWhere();
		return countHql.toString();
	}

	//获取参数的列表
	public List getParamList() {
		builderWhere();
		return paramList;
	}

	// 封装公共当前页码,一页条数:都必须有get,set
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		
		//当传过来的是其他字符的时候要进行判断处理
/*		String currentPageString = currentPage.toString();
		System.out.println("BaseQuery:current:PageString"+currentPageString.toString());
		if(isNumeric(currentPageString)){
			this.currentPage = Integer.parseInt(currentPageString);
		}else{
			this.currentPage = 1;
			
		}*/
		
		this.currentPage =  currentPage;
		
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public  boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    System.out.println("isNumber"+str.toString());
	    return pattern.matcher(str).matches();    
	 }
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public void setHql(StringBuilder hql) {
		this.hql = hql;
	}
	public void setCountHql(StringBuilder countHql) {
		this.countHql = countHql;
	}
	public void setParamList(List paramList) {
		this.paramList = paramList;
	} 
	
	

}
