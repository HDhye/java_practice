package com.ohgiraffers.hw1.comparator;

import java.util.Comparator;

import com.ohgiraffers.hw1.model.dto.BookDTO;

public class DescBookNo implements Comparator<BookDTO> {


	@Override	// 구현을 강제화 
	public int compare(BookDTO o1, BookDTO o2) {		 

		
		return o1.getbNo() > o2.getbNo() ? -1 : 1; // 양수, 음수, 0으로 반환 
	}

	


}
