package cn.edu.fjnu.cdio4.xplan.page;

import java.util.ArrayList;
import java.util.List;


/**
 *类的作用：封装所有的查询结果
 *
 *
 *@author 一叶扁舟
 *@version 1.0
 *@创建时间： 2014-11-11   下午08:27:54
 */
public class PageResult<T> {
	// 当前页码,一页条数
	private int currentPage;
	//每页的记录数
	private int pageSize;
	// 总记录数
	private int totalCount;
	// 总的页数:计算
	private int totalPage;
	// 当前页码的数据
	private List<T> rows = new ArrayList<T>();

	public PageResult() {

	}

	/**
	 * @param currentPage 当前页
	 * @param pageSize  每页的记录数
	 * @param totalCount  总共的记录数
	 * 下面包含了很多错误的处理，包括输入当前页数大于系统的总页数和输入当前页小于0等情况。
	 */
	public PageResult(int currentPage, int pageSize, int totalCount) {
		// 对输入的数据进行过滤处理
		this.currentPage = currentPage < 1 ? 1 : currentPage;
		this.pageSize = pageSize < 1 ? 10 : pageSize;
		this.totalCount = totalCount;
		// 计算总页数
		// 以下的代码必须加上this，分页的一种计算方式，比上面的计算方式效率高
		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
		// 当前页码大于总的页数必须在最后面处理
		this.currentPage = this.currentPage >= this.totalPage ? this.totalPage : this.currentPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageResult [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", rows.size=" + rows.size() + "]";
	}

}
