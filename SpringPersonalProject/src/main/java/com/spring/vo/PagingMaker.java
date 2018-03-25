package com.spring.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PagingMaker {
	private int totalData; //number of total Data
	private int startPage; //start number of Page List 
	private int endPage;   //end number of Page List
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10;  //페이지 목록에 나타날 페이지 수
	
	private PageCriteria pageCriteria;
	
	public void setPageCriteria(PageCriteria pageCriteria){
		this.pageCriteria = pageCriteria;
	}
	
	public void setTotalData(int totalData){
		this.totalData = totalData;
		
		getPagingData();
	}
	
	//Paging処理のため必要な情報を求めるMethod
	private void getPagingData(){
		endPage = (int)(Math.ceil(pageCriteria.getPage() / (double)displayPageNum) * displayPageNum);
		startPage = endPage - displayPageNum + 1;
		
		int finalEndPage = (int)(Math.ceil(totalData / (double)pageCriteria.getNumPerPage()));
		if(endPage > finalEndPage){
			endPage = finalEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage * pageCriteria.getNumPerPage() >= totalData ? false : true;
	}
	
	public String makeURI(int page){
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("numPerPage", pageCriteria.getNumPerPage())
				.build();
		
		return uriComponents.toUriString();
	}
	
	public String makeFindURI(int page){
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("numPerPage", pageCriteria.getNumPerPage())
				.queryParam("findType", ((FindCriteria)pageCriteria).getFindType())
				.queryParam("keyWord", ((FindCriteria)pageCriteria).getKeyWord())
				.build();
		
		return uriComponents.toUriString();
	}
	
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalData() {
		return totalData;
	}

	public PageCriteria getPageCriteria() {
		return pageCriteria;
	}
}
