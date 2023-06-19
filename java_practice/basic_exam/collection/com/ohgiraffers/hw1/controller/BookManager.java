package com.ohgiraffers.hw1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ohgiraffers.hw1.comparator.AscBookNo;
import com.ohgiraffers.hw1.comparator.AscBookTitle;
import com.ohgiraffers.hw1.comparator.DescBookNo;
import com.ohgiraffers.hw1.comparator.DescBookTitle;
import com.ohgiraffers.hw1.model.dto.BookDTO;

public class BookManager {
	
	private ArrayList<BookDTO> booklist;		
	private Scanner sc = new Scanner(System.in);

	private int i = 0; 
	
	/* 기본 생성자 */
	public BookManager() {
		/* ArrayList<BookDTO> 객체 생성 */
		booklist = new ArrayList<>();
	
	}
	/**
	 * <pre>
	 * 전달받은 도서정보를 booklist에 담는다. 
	 * @param book 추가할 도서정보 
	 */
	public void addBook(BookDTO book) {
	
		booklist.add(book);
		
	}
	
	/**
	 * 전달받은 도서번호를 이용하여 해당하는 인덱스에 도서를 제거한다
	 * @param index 도서번호(1 ~ 100000000 )
	 */
	public void deleteBook(int index) {
		
		for (int i = 0; i < booklist.size(); i++) {
			if (index == booklist.get(i).getbNo()) { 
				booklist.remove(i);
			}
		}
	}
	
	/**
	 * 전달받은 도서제목의 도서를 찾고 해당 도서의 정보를 출력한다.
	 * @param btitle 도서제목 
	 */
	public void searchBook(String btitle) {
		
		if(booklist.toString().contains(btitle)) {
			
			for (int i = 0; i < booklist.size(); i++) {
			
				if(booklist.get(i).toString().contains(btitle)) {
					System.out.println(booklist.get(i)); 
				}
			}
		} 
		else {
			System.out.println("조회된 도서가 목록에 없습니다.");
		}
	}
	
	/**
	 * 도서 전체목록을 출력한다. list의 갯수(요소)가 0개이면 "없습니다." 결과를 출력한다.
	 */
	public void displayAll() {
		
		if(booklist.size() == 0) {
			System.out.println("출력결과가 없습니다.");
			
		} else {
			for(int i = 0; i < booklist.size(); i++) {
				System.out.println(booklist.get(i));
			}
		}
	}
	
	/**
	 * 매개변수로 전달받은 숫자에 해당하는 정렬방식에 따라서 
	 * 오름차순/내림차순으로 정렬하여 정렬된 list의 주소값을 반환한다.
	 * @param BookMenu에서 전달된 정렬방식 선택 번호 
	 * @return 선택한 정렬방식 메소드의 리스트 반환 값을 printBookList 메소드에 전달인자로 전달하게 된다. 
	 */
	public List<BookDTO> sortedBookList(int type){
		
		outer:
		while(true) {

			switch(type) {
				/* 정렬방식을 1~4로 제대로 입력하게 되면 while문을 탈출하여 리턴값을 얻을 수 있다.*/
				case 1 : booklist.sort(new AscBookNo());		
						 break outer; 
				case 2 : booklist.sort(new DescBookNo());
						 break outer;
				case 3 : booklist.sort(new AscBookTitle());
						 break outer;
				case 4 : booklist.sort(new DescBookTitle());
						 break outer;
						 /* 1~4 외에 번호를 입력하게 되면 다시 while문의 switch문을 반복하여 제대로 선택하게 한다. */
				default : System.out.println("잘못 입력하였습니다. 다시 입력하세요."); break;
			} 
		}
		
		return booklist;
	}
	
	/**
	 * 정렬된 리스트 객체의 도서를 출력한다. 
	 * @param printList sortedBookList에서 반환된 객체를 전달인자로 받는다.  
	 */
	public void printBookList(List<BookDTO> printList) {
		
		for(BookDTO sortedBookList : printList) {
			
			System.out.println(sortedBookList);
		}
		
	}
	
	
}
