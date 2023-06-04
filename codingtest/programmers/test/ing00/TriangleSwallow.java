package programmers.test.ing00;

/**
 * 삼각달팽이 배열 
 * @출처: 프로그래머스 코딩테스트 연습
 * @since 20230510 ~ 미완료 
 * @author hdhye
*/
public class TriangleSwallow {
	
	public static void main(String[] args) {
		/*
		 * 정수 n이 매개변수로 주어집니다. 
		 * 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 
		 * 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
		 * 
		 * 4	[1,2,9,3,10,8,4,5,6,7]
		 * 5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
		 * 6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
		 * */

		/* 
		 * [0][0],[1][0],[2][0],[3][0],[4][0], [5][0] 	// i 증가, i가 n-1(length-1)일때 i는 멈추고  j 1씩 증가 
		 * [5,1] [5,2] [5,3] [5, 4] [5,5] 				// j 증가, j가 n-1(length-1)일때, i와 j 1씩 감소(처럼 보이나 i가 감소한거임. 조건은 항상 length-1) 
		 * [4,4][3,3][2,2] [1,1]						// i, j 동시감소, [0,0]은 1일때, i 1씩 증가 
		 * [2,1][3,1] [4,1]								// i 증가, [5,1]은 1일때, j 1씩 증가   
		 * [4,2] [4,3]									// j 증가, [4,4]가 1일때, i 1감소 
		 * 공통조건: j는 length-1보다 작다. 지나가는 인덱스마다 1을 삽입해주고 1을 마주칠때 증감시킨 후, 1을 찍으면서 간다.  
		*/
		
		// 순회 
		// 1. i가 증가, 
		// 2. j가 증가 , i일정 
		// 3. i가 감소, 

		int n = 5; // 1이상 1000 이하 
		
		// 가변배열  생성 
		int[][] arr = new int[n][];
		// 가변배열 만들기
		for(int i = 0; i < n; i++) {
			arr[i] = new int[i+1]; 
		}
		
		int i = 0;
		int j = 0; 
		int num = 1; 
		System.out.println(sum(n));
	
		do {
			arr[i][j] = num; 
			i++;  
			num++; 
			if(i >= arr.length || arr[i][j] != 0) {		// 방향전환 1
				i--;
				j++; 				// 전환후 시작인덱스  재설정  
				while(num <= sum(n)) {
					arr[i][j] = num;
					j++; 
					num++; 
					if(j >= arr[i].length-1 || arr[i][j] != 0) {  // 방향전환 2
						arr[i][j] = num; 
						j--;
						i--; 				// 전환후 시작인덱스 재설정
						num++; 
						while(num <= sum(n)) {
							arr[i][j] = num;  
							i--; 
							j--;
							num++; 
							if(arr[i][j] != 0) {  // 방향전환 3 
								j++; 
								i += 2;				// 전환 후 시작인덱스 재설정
								
							}
						}
					}
				}
			}
		} while(num <= sum(n));
		
		
	}
	
	private static int sum(int n) {
		int sum = 0; 
		while(n > 0) {
			sum += n; 
			n--; 
		}
		return sum;
	}

}
