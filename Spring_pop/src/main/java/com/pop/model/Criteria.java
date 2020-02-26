package com.pop.model;

public class Criteria {
	// 페이지번호
	private int pageNum;
	// 한 페이지 당 데이터 처리 갯수(10개)
	private int amount;
	
	private String keyword;
	
	public Criteria () {		// 기본생성자	
		this(1,10);
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Criteria(int pageNum, int amount) {	//생성자(매개변수 2개)
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	}
}
