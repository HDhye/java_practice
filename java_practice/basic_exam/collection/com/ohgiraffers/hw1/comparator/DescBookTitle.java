package com.ohgiraffers.hw1.comparator;

import java.util.Comparator;

import com.ohgiraffers.hw1.model.dto.BookDTO;

public class DescBookTitle implements Comparator<BookDTO> {


	@Override	// 구현을 강제화 
	public int compare(BookDTO o1, BookDTO o2) {		 

		
		return o2.getTitle().compareTo(o1.getTitle()); // 양수, 음수, 0으로 반환 
	}

	

}
