package array.level02.normal;

import java.util.Scanner;

public class Application5 {

	public static void main(String[] args) {
		
		/* 후라이드, 양념, 파닭, 매콤, 치즈, 간장이라는 메뉴 치킨 메뉴를
		 * 배열에 초기화하고, 사용자가 입력한 값이 배열에 있는지 검색하여
		 * 있으면 "OOO 치킨 배달 가능", 없으면 "OOO 치킨은 없는 메뉴입니다"
		 * 를 출력하세요
		 * 
		 * ========== 출력 ===========
		 * 치킨 이름을 입력하세요 : 양념
		 * 양념치킨 배달 가능
		 * 
		 * 치킨 이름을 입력하세요 : 달콤
		 * 달콤치킨은 없는 메뉴입니다.
		 * */
		
		String[] chicken = {"후라이드", "양념", "파닭", "매콤", "치즈", "간장"};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("치킨 이름을 입력하세요. : ");
		String order = sc.nextLine();
		
		
		int possible = 0; 
		
		for(int i = 0; i < chicken.length; i ++) {
			
			if( chicken[i].equals(order) == true )
				possible++ ;
		}
		
		if(possible != 0) {
			
			System.out.println(order + "치킨 배달 가능");
			
		} else System.out.println(order + "치킨은 없는 메뉴입니다.");
		
	}
}
