package cn.oge.Util;

import java.util.List;

public class Page {

	private int currPage; // 当前页
	private int pageCount; // 每页显示多少条
	private int totalCount; // 总条数
	private int totalPages; // 总页数

	private List list;// 每一页的数据

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPages() {
		return this.getTotalCount() % this.getPageCount() == 0 ? this
				.getTotalCount() / this.getPageCount() : this.getTotalCount()
				/ this.getPageCount() + 1;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
