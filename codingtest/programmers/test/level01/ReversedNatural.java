package programmers.test.level01;

import java.util.Arrays;

/**
 * 자연수 뒤집어 배열로 만들기
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
 * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 * n은 10,000,000,000이하인 자연수입니다.
 * @since 20230527 풀이 완료
 * @author hdhye
 * @출처: 프로그래머스 코딩테스트 연습
 * {@link https://school.programmers.co.kr/learn/courses/30/lessons/12932} 
 */
public class ReversedNatural {
	
	static final long n = 12345L; 

	public static int[] solution(long n) {
		
		String str = n + ""; // 자연수를 문자열로 만든다 
//		String str = Long.toString(n); // 래퍼클래스 이용 
		
		// 스트링빌더를 이용하여 reverse()메소드를 사용 후 다ㅣ 문자열로 받기  
		String reverseStr = new StringBuilder(str).reverse().toString();
		
		// 뒤집어서 받은 문자열을 문자배열로 변환 => ※ 주의 : 아스키코드로 들어가있음 
		char[] charr = reverseStr.toCharArray(); 
		
		// 마지막으로 문자배열을 정수배열로 변환 
		int[] answer = new int[charr.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = charr[i] - '0' ; // 아스키코드에 주의하여 '0'을 빼줄 것  
		}
		
		return answer;
	}
	

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(n)));
	}
}

