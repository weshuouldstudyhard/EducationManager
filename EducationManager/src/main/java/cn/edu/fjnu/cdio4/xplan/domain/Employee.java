package cn.edu.fjnu.cdio4.xplan.domain;

/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-12   下午11:07:49
 */
public class Employee {
	private Long id;
	private String name;
	private int age;
	
	
	public Employee() {
		super();
	}
	
	
	/**
	 * @param id
	 */
	public Employee(Long id) {
		super();
		this.id = id;
	}
	
	


	/**
	 * @param name
	 * @param age
	 */
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [age=" + age + ", id=" + id + ", name=" + name + "]";
	}
	
}
