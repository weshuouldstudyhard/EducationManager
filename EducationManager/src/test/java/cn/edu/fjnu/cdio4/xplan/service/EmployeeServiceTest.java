package cn.edu.fjnu.cdio4.xplan.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.fjnu.cdio4.xplan.domain.Employee;

/**
 *类的作用：
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-12   下午03:28:07
 */
public class EmployeeServiceTest extends BaseServiceTest {
	@Autowired
	IEmployeeService employeeService;

	@Test
	public void testSave() throws Exception {
		Employee employee1 = new Employee();
		employee1.setAge(12);
		employee1.setName("hehe");
		
		Employee employee2 = new Employee("高飞", 22);
		Employee employee3 = new Employee("江晨", 22);
		Employee employee4 = new Employee("陈杰", 22);
		Employee employee5 = new Employee("刘婉冬", 21);
		Employee employee6 = new Employee("兰钦红", 22);
		Employee employee7 = new Employee("一叶扁舟", 23);
		Employee employee8 = new Employee("无悔", 20);
		employeeService.save(employee1);
		employeeService.save(employee2);
		employeeService.save(employee3);
		employeeService.save(employee4);
		employeeService.save(employee5);
		employeeService.save(employee6);
		employeeService.save(employee7);
		employeeService.save(employee8);
	}
}
