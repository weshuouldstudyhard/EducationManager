package cn.edu.fjnu.cdio4.xplan.action;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;


/**
 *类的作用：封装最基本的crud操作
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-12   下午10:01:35
 */
public abstract class CRUDAction<T> extends BaseAction implements Preparable {
	protected Long id;

	public Long getId() {
		return id;
	}

	
	/**
	 * 
	 * 在paramsPrepareParamsStack拦截器设置中，先调用的params -->prepare --> ModelDriven -->params
	 * 在这个顺序中第一步调用的是setId() 
	 * （这个针对的是新建，查询，修改而言的）
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	// 不写代码
	public void prepare() throws Exception {
	}

	// 列表（下面当出现转换异常的时候，就让这个界面跳转到当前界面）
	@Override
	@InputConfig(methodName = "execute")
	public String execute() throws Exception {
		list();
		return SUCCESS;// 访问子类的list方法
	}

	// employee_list.action是不能成功访问,
	//应为action中的方法，必须是public
	protected abstract void list() throws Exception;

	// 添加页面和修改页面
	@Override
	public String input() throws Exception {
		System.out.println("CRUDAction input():");
		return INPUT;
	}

	// 保存
	public abstract String save() throws Exception;

	// 删除
	public abstract String delete() throws Exception;

	/*
	 * 第二步:调用这个方法
	 * 
	 *  action.input方法
	 */
	public void prepareInput() throws Exception {
		beforeInput();
	}

	
	public void prepareSave() throws Exception {
		beforeSave();
	}

	protected abstract void beforeInput() throws Exception;

	protected abstract void beforeSave() throws Exception;

}

