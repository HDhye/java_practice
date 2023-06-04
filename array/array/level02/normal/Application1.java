package array.level02.normal;

import java.util.Scanner;

public class Application1 {

	public static void main(String[] args) {
		
		/* 문자열을 하나 입력받아 문자 자료형 배열로 바꾼 뒤
		 * 검색할 문자를 하나 입력 받아 
		 * 입력 받은 검색할 문자가 문자열에 몇개 있는지를 출력하세요
		 * 
		 * -- 입력 예시 --
		 * 문자열을 하나 입력하세요 : helloworld
		 * 검색할 문자를 입력하세요 : l
		 * 
		 * -- 출력 예시 --
		 * 입력하신 문자열 helloworld에서 찾으시는 문자 l은 3개 입니다.
		 * */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 하나 입력하세요 : ");
		
		String str = sc.nextLine(); 
		char[] charr = new char[str.length()];	// 문자열의 길이는 length;, String은 메소드 length(); 
		
		System.out.print("검색할 문자를 입력하세요 : "); 
		char ch = sc.next().charAt(0);

		int num = 0; // 찾으려고 하는 문자가 몇개 있는지 누적하기 위한 용도의 변수 
		
		for(int i = 0; i < charr.length; i++) {
			
			charr[i] = str.charAt(i); 		// char[] charr = str.toCharArray(); 메소드도 이용 가능 
			
			if(ch==charr[i]) {
				num++; 
			}
		}
		
		System.out.println("입력하신 문자열 " + str + "에서 찾으시는 문자 '" + ch + "'은 " + num + "개 입니다.");
		
		sc.close();
	}

}
