package array.level02.normal;

public class Application6 {

	public static void main(String[] args) {
		
		/* 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
		 * 1 ~ 10 사이의 난수를 발생시켜 배열에 초기화 후
		 * 배열 전체 값과 그 값 중에서 최대값과 최소값을 찾아서 출력하세요.
		 * 
		 * =========== 출력 ============
		 * 2 10 5 2 3 7 3 7 9 7
		 * 최대값 : 10
		 * 최소값 : 2
		 * */
		
		int[] arr = new int[10]; 
		
		int tmp = 0; 
		
		
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = (int)(Math.random()*10)+1;
		}
		
		for( int i = 1; i < arr.length; i++) {
			
			for( int j = 0; j <i; j++) {
				
				if( arr[i] < arr[j] ) {
					
					tmp = arr[j];
					arr[j] = arr[i];
					arr[i]= tmp; 
				}
				
			}
		}
		System.out.println("최소값 : " + arr[0] + " 최대값 : " + arr[arr.length-1] );
	}
}
