package com.ohgiraffers.hw1.model.dto;

public class BookDTO{
	
	
	private int bNo;			// 도서 번호(ISBN)
	
	private String title;		// 도서 제목
	private int category;		// 도서 장르 
	private String author;		// 도서 저자
	
	public BookDTO() {	}

	public BookDTO(String title, int category, String author) {
		this.title = title;
		this.category = category;
		this.author = author; 
	}

	public BookDTO(int bNo) {
		this.bNo = bNo;
	}

	public int getbNo() {
		return bNo;
	}

	/**
	 * 도서번호를 입력하는 메소드
	 * 최초 도서 1번부터 순서대로 1씩 증가 
	 * @param bNo 도서번호 
	 */
	public void setbNo(int bNo) {
		if(this.bNo == bNo) {
			bNo = (int)(Math.random()*100)+1;
		} 
		this.bNo = bNo;
		
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		
		return  "책 정보 [ 번호 = " + bNo +
				", 제목 = " + title + 
				", 장르 분류번호(1:인문 / 2:자연과학 / 3:의료 / 4:기타) = " + category + 
				", 저자 = " + author +  "]";
		}
	
	
	
	
	

}
