package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
    int startPage; // 현재 페이지 기준 첫번째 페이지정보.
    int endPage; // 현재 페이지 기준 마지막 페이지 정보.
    boolean prev, next; //  
    int currentPage; // 
    
    public PageDTO(int page, int totalCnt) {
    	this.currentPage = page; // 12 page
    	this.endPage = (int) Math.ceil(page / 10.0) * 10; // 20 page
    	this.startPage = this.endPage - 9; // 11 page
    	
    	// 실제 마지막 페이지.
    	int realEnd = (int) Math.ceil(totalCnt / 5.0); // 87건. => 18페이지.
    	this.endPage = this.endPage > realEnd ? realEnd:this.endPage;
    	
    	
    	
    	this.prev = this.startPage > 1; // 이전 10개 목록이 있음.
    	this.next = this.endPage < realEnd ? true : false; 
    }
}
