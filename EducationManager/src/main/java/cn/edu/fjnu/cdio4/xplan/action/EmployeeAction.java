package cn.edu.fjnu.cdio4.xplan.action;

import java.util.HashMap;
import java.util.Map;

import cn.edu.fjnu.cdio4.xplan.domain.Employee;
import cn.edu.fjnu.cdio4.xplan.page.EmployeeQuery;
import cn.edu.fjnu.cdio4.xplan.page.PageResult;
import cn.edu.fjnu.cdio4.xplan.service.IEmployeeService;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 *类的作用：操作员工的action，这个类中涉及CRUD操作所以要继承CRUDAction
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-13   上午12:45:46
 */
public class EmployeeAction extends CRUDAction<Employee> {
	private IEmployeeService employeeService;
	private PageResult<Employee> pageResult;
	private EmployeeQuery baseQuery = new EmployeeQuery();
	private Employee employee;

	public EmployeeQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(EmployeeQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public PageResult<Employee> getPageResult() {
		return pageResult;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getModel() {
		return employee;
	}

	//这个是针对如果查询条件中要是有下拉框的选择的查询（也就是范围内查询，不是直接输入的）
	@Override
	protected void list() throws Exception {
		logger.debug("list");
		this.pageResult = employeeService.findPageResult(baseQuery);
	}


	//一般这个方法写的是一些下拉列表框中的数据，从这个里面放入作用域中的
	//这个是只是针对输入数据的下拉框
	@Override
	public String input() throws Exception {
		logger.debug("input");
		return INPUT;
	}

	@Override
	// 保存的时候:如果出现转换异常:把字符串放到了Integer属性里面 ,默认会跳转到input指向的jsp页面
	@InputConfig(methodName = "input")
	public String save() throws Exception {
		logger.debug("save");
		
		if (id == null) {
			employeeService.save(employee);
		} else {
			employeeService.update(employee);
		}
		addActionMessage("保存成功");
		return RELOAD;
	}

	// ajax删除，利用异步删除的方法，页面并未刷新
	@Override
	public String delete() throws Exception {
		logger.debug("delete");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (id != null) {
				employeeService.delete(id);
				map.put("success", true);
				// 将信息放入作用域中，在页面取出对应的提示信息，这个我没有测试成功
				// 你们不用管它
				map.put("msg", "删除成功");
			} else {
				map.put("success", false);
				map.put("msg", "不能获取到id的值");
			}
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", e.getMessage());
		}
		putContext("map", map);
		return JSON;
	}

	@Override
	protected void beforeInput() throws Exception {
		logger.debug("beforeInput");
		if (id != null) {
			employee = employeeService.get(id);// 回显
		}
	}

	@Override
	protected void beforeSave() throws Exception {
		logger.debug("beforeSave");
		if (id == null) {
			employee = new Employee();
		} else {
			// employee持久状态
			employee = employeeService.get(id);// 把数据从数据库加载出来,没有在jsp页面出现的属性不会丢失
		
		}
	}	

}
