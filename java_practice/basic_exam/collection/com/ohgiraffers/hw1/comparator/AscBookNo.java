package com.ohgiraffers.hw1.comparator;
import java.util.Comparator;

import com.ohgiraffers.hw1.model.dto.BookDTO;

/**
 * @author hdhye
 * 도서번호(ISBN) 오름차순 정렬 메소드
 */
public class AscBookNo implements Comparator<BookDTO> {

	@Override	// 구현을 강제화 
	public int compare(BookDTO o1, BookDTO o2) {		 

		/* 오름차순 : 양수를 반환해주면 자리를 바꾼다. */
		return o1.getbNo() < o2.getbNo() ? -1 : 1; // 양수, 음수, 0으로 반환 
	}

	


}
