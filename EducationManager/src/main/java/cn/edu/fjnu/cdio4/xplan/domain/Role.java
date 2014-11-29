package cn.edu.fjnu.cdio4.xplan.domain;

import java.util.Set;

/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-27   上午10:30:46
 */
public class Role {
	

	/*id:主键*/
	private Long id;
	/*name:资源的名字*/
	private String name;
	/*一个角色对应多种资源*/
	private Set<Resource> resources;
	
	
}
