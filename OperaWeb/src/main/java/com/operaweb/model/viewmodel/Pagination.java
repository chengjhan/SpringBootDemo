package com.operaweb.model.viewmodel;

import java.util.List;

public class Pagination<T> {

	private List<T> list;
	private long count;
	private int pageNumber;
	private int pageSize;

	public int getPageCount() {
		return (int) Math.ceil(count / (double) pageSize);
	}

	public boolean hasPrevious() {
		return pageNumber > 1;
	}

	public boolean hasNext() {
		return pageNumber < getPageCount();
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
