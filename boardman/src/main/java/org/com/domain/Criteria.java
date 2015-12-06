package org.com.domain;

public class Criteria {

	private int pageNo;
	private int perPage;

	public Criteria() {
		this.pageNo = 1;
		this.perPage = 20;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		if( perPage <= 0 || perPage > 100 ){
			this.perPage = 20;
			return;
		}
		
		this.perPage = perPage;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if(pageNo <=0 ){
			this.pageNo = 1;
			return;
		}
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "Criteria [pageNo=" + pageNo + ", perPage=" + perPage + "]";
	}

	
}
