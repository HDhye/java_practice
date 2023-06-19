package com.ohgiraffers.hw1.view;

import java.util.List;
import java.util.Scanner;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

/**
 * @author hdhye
 * @title 도서관리 프로그램 메인메뉴(View)
 */
public class BookMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	/* BookManager(controller)의 메소드를 실행하기 위해 생성해준다.*/
	private BookManager bm = new BookManager();
	
	private int i = 1;  // 도서번호를 증가시킬  변수 선언. 번호는 1부터 시작한다. 
	
	/* BookMenu의 기본생성자*/
	public BookMenu() {	}
	
	/**
	 * <pre>
	 * 도서관리 프로그램에 해당하는 메인 메뉴 출력, 각 메뉴에 해당하는 BookManager 클래스의 메소드 실행하고 
	 * 반복 출력되게 하는 메소드이다. 
	 * 메뉴: 1. 새도서 추가 2. 도서정보 정렬 후 출력 3. 도서 삭제 4. 도서 검색출력 5. 전체출력 6.끝내기 
	 * 해당 메뉴 번호에 따라 BookManager 클래스 메소드를 실행하고 
	 * 전달인자로는 BookMenu 메소드의 리턴값을 전달받는다. 
	 * </pre>
	 */
	public void mainMenu() {
		
		while(true) {
			
			/* 사용자 화면 */
			System.out.println(" *** 도서 관리 프로그램 *** ");
			System.out.println("1. 새 도서 추가 ");
			System.out.println("2. 도서정보 정렬 후 출력 ");
			System.out.println("3. 도서 삭제 ");
			System.out.println("4. 도서 검색 출력 ");
			System.out.println("5. 전체 도서 출력 ");
			System.out.println("6. 끝내기 "); 
			
			System.out.print("메뉴 번호 선택 : ");		// 선택할 메뉴번호 키보드로 입력 받음 
			int number = sc.nextInt();	
			sc.nextLine();
			
			switch(number) {
			
				case 1 : bm.addBook(inputBook()); break;				// 도서 추가
				case 2 : bm.printBookList(selectSortedBook()); break;	// 도서정보 정렬 후 출력
				case 3 : bm.deleteBook(inputBookNo()); break;			// 도서 삭제(도서번호 -1 = 삭제할 도서의 인덱스번호)
				case 4 : bm.searchBook(inputBookTitle()); break;		// 도서 검색 출력
				case 5 : bm.displayAll(); break;						// 전체도서 출력
				case 6 : return;										// 끝내기
				default : System.out.println("잘못 입력하셨습니다."); break;	
			}
			
		}
		
	}
	
	/**
	 * <pre> BookDTO 객체의 필드 값(도서 제목, 도서 장르, 도서 저자)을 키보드로 입력 받아 초기화 하고 
	 * 객체를 리턴하는 메소드 (카테고리는 (1.인문/2.자연과학/3.의료/4.기타) 으로 한다.)
	 * </pre>
	 * @return 생성자를 이용해 초기화한 DTO 객체를 리턴하여 mainMenu에 lm.addBook 메소드에 전달인자로 전달한다. 
	 */
	public BookDTO inputBook() {
		

		/* BookDTO의 매개변수 생성자의 매개변수로 전달할 값을 키보드로 입력받는다. */
		System.out.print("도서 제목 : ");
		String title = sc.nextLine();
		
		System.out.print("도서 장르 (1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");
		int category = sc.nextInt();
		sc.nextLine();
		System.out.print("저자 : ");
		String author = sc.nextLine();

		
		/* BookDTO의 매개변수 있는 생성자로 초기화한다.*/
		BookDTO inputBook = new BookDTO(title, category, author);
		inputBook.setbNo((int)(Math.random()*10000000)+1); // 도서번호는 1부터 시작하여 1씩 증가
		return inputBook;	// 초기화하여 리턴받은 객체주소값 
	}
	
	/**
	 * <pre> 
	 * 삭제할 도서번호를 키보드로 입력 받는 메소드
	 * </pre>
	 * @return 삭제할 도서번호를 리턴하여 mainMenu에 deleteBook 전달인자로 전달한다.
	 */
	public int inputBookNo() {
		
		System.out.print("도서 번호 :");
		int inputBookNo = sc.nextInt();  
		
		return inputBookNo;
		
	}
	
	/**
	 * <pre>
	 * 검색할 도서제목을 키보드로 입력 받는 메소드
	 * </pre> 
	 * @return 검색할 도서제목을 리턴하여  mainMenu에 searchBook 전달인자로 전달한다.
	 */
	public String inputBookTitle() {
		
		System.out.print("도서 제목 : ");
		String inputBookTitle = sc.next();
		
		return inputBookTitle;
	}
	
	/**
	 * <pre>
	 * 도서출력시 정렬방식을 선택하는 메소드. 키보드로 입력받아 정렬방식 선택  
	 * 정렬방식: 1.도서번호(ISBN)으로 오름차순 2.도서번호(ISBN)으로 내림차순 3.책제목 오름차순 4.책제목 내림차순
	 * </pre>
	 * @return 도서출력 정렬방식을 리턴하여 mainMenu에 lm.printBookList 메소드의 전달인자로 전달한다.
	 */
	public List<BookDTO> selectSortedBook(){
		
		System.out.println(" 1. 도서번호(ISBN)으로 오름차순정렬");
		System.out.println(" 2. 도서번호(ISBN)으로 내림차순정렬");
		System.out.println(" 3. 책 제목으로 오름차순 정렬 ");
		System.out.println(" 4. 책 제목으로 내림차순 정렬");
		System.out.print(" 도서 정렬 방식 번호 선택 :  ");
		List<BookDTO> selectSortedBook = bm.sortedBookList(sc.nextInt());
				
		return selectSortedBook;
	}
	

}
