package com.HDhye.array;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		
		/* 숫자 야구게임 만들기 
		 * 길이 4의 정수 배열을 만들고 각 인덱스에는 0 ~ 9까지의 중복되지 않는 난수를 저장한다.
		 * 4자리 숫자를 입력받아 스트라이크, 볼 등의 힌트를 주며 4자리 난수 숫자를 맞추는 게임이다.
		 * 숫자와 자리가 모두 맞는 경우 스트라이크, 숫자는 맞지만 자리는 맞지 않는 경우는 볼 이다.
		 * 예) 9183 으로 난수가 발생하면 9356 입력 시 1S 1B이다.
		 * 
		 * 단, 기회는 총 10번이며, 10번 이내에 맞추는 경우 "정답입니다." 출력 후 게임 종료
		 * 10번의 기회가 모두 소진 되면 "10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다." 출력 후 종료
		 * 
		 * 또한 4자리의 정수를 입력하지 않은 경우에는 "4자리의 정수를 입력해야 합니다." 출력 후 입력을 다시 받을 수 있되
		 * 횟수는 차감하지 않는다.
		 * 
		 * -- 프로그램 예시 (난수 7416 의 경우) --
		 *
		 * 10회 남으셨습니다.
		 * 4자리 숫자를 입력하세요 : 1234
		 * 아쉽네요 0S 2B 입니다.
		 * 9회 남으셨습니다.
		 * 4자리 숫자를 입력하세요 : 5678
		 * 아쉽네요 0S 2B 입니다.
		 * 8회 남으셨습니다.
		 * 4자리 숫자를 입력하세요 : 7416
		 * 정답입니다.
		 * */
		
		// 난수퀴즈 배열 선언 생성 
		int[] question = new int[4];
		
		
		// 난수퀴즈 배열만들기 
		for(int i = 0; i < question.length; i++) {
			
			question[i] = (int)(Math.random()*9);
			
			for(int j = 1; j < i; j++) {
				
				if(question[i] == question[j]) {
					i--;
					break; 
				}
			} 
		}
		
		// 난수퀴즈 String 변환
		String tmpQ = "" + question[0]+question[1]+question[2]+question[3];
		
		// 난수퀴즈 확인용 출력문 
		System.out.print("정답 : ");
		for(int i = 0; i < question.length; i++) {
			
			System.out.print(question[i]);
		}
		
		System.out.println();
		
		// 입력하는 답 입력 
		Scanner sc = new Scanner(System.in);
		int[] answer = new int[4];

		int str = 0;	// 스트라이크 - 값, 인덱스 맞추면 
		int ball = 0; 	// 볼 - 값만 맞추면  
		int count = 10; 	// 기회 10번  
		// continue 하면서 count--; 차감 후, 입력을 다시 받을수 있게 
		
		// 무한 반복 시작  
		outer: 
		for(;;) {
			
			//일단 스트링으로 담아서 정수배열로 변환해줄거임 (나중에 스트링형 정답끼리 비교하려고)
			System.out.print("정수 4자리를 입력하세요. : ");
			String tmpA = sc.nextLine();
			
			// 입력값이 4개가 아니면 반복문 다시 돌기 
			if(tmpA.length()!=4) {
				System.out.println("4자리의 정수를 입력해야 합니다.");
				continue outer;
			}
		
			// 입력 답 배열 만들고 출력
			for(int i = 0; i < answer.length; i++) {
				
				// 스트링형 입력답 정수배열에 담기 (문자형->정수 =아스키값이라서 - '0' 값 빼주기)
				answer[i] = (int)(tmpA.charAt(i)-'0');
				System.out.print(answer[i]+"");	
				
			}
			System.out.println();
			
			// ball 카운팅 반복문 
			for(int i = 0; i < answer.length; i++) {
				
				for(int j = 0; j < answer.length; j++) {
					
					//일단 자리 상관없이 값이 같은 경우 ball 1씩 증가시킴 (중복 제거 예정) 
					if(question[i] == answer[j]) {
						ball++; 
						break; // 값 같은거 처음 1개 발견했으면 바로 나와 (중복 볼 카운팅 방지)
					}
				}
			}
			
			// 자리랑 값이 동일한 경우 strike 1씩 증가  
			for(int i =0; i < answer.length; i++) {
				
				if(question[i] == answer[i]) {
					str++;
					--ball; // 자리가 같으면 이미 ball카운팅에서 +1됐으므로 중복이므로 볼 감소 
				}
			}
				
			
			//정답 다 맞춘 거
			if(tmpA.equals(tmpQ) == true ) {
				System.out.println("정답입니다.");
				
				break outer;
			} 
			
			// 틀렸을 경우 
			else {
				System.out.println("아쉽네요. " + str +"S " + ball + "B 입니다.");

				--count; //카운트 1개씩 감소 
				
				// 카운트가 0이 됐을때 프로그램 종료 (리턴문으로 메소드 아예 종료시킴) or break outer;
						if( count == 0 ) {
							System.out.println("10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다.");
						break outer; 	}
				
				System.out.println(count + "회 남으셨습니다.");
				continue outer;		// 입력 반복문으로 이동 
			} 
		}
		
	}
}
