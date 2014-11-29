package cn.edu.fjnu.cdio4.xplan.domain;

/**
 *类的作用：资源的实体类，其实就是具体的权限控制
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-27   上午10:31:06
 */
public class Resource {
	
	/*id:主键*/
	private Long id;
	/*name:资源的名字*/
	private String name;
	/*method:权限定名+方法名*/
	private String method;
	/*desecription:描述method和name的信息*/
	private String description;

}
