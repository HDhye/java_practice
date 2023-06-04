package programmers.test.level01;


/**
 * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 
 * 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 
 * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
 * 
 * 공백은 아무리 밀어도 공백입니다.
 * s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
 * s의 길이는 8000이하입니다.
 * n은 1 이상, 25이하인 자연수입니다.
 * @since 20230528 풀이 완료
 * @author hdhye
 * @출처: 프로그래머스 코딩 테스트 연습
 * {@link https://school.programmers.co.kr/learn/courses/30/lessons/12926}
 */
public class CaesarPassword {

	static final String s1 = "AB";
	static final String s2 = "z";
	static final String s3 = "a B z";
	static final int n1 = 1;
	static final int n2 = 1;
	static final int n3 = 4;
	
	/* 아스키코드를 이용하기 위해 주어진 문자열을 문자로 변환하여 n만큼 더한다.
     * ※주의 : 예를 들어 z에서 1만큼 밀리는 경우 a로 다시 돌아와야기에 
     * 		   조건 실행문에 공식 + ( -'z' + 'a' -1 )을 추가해준다.
     * 		   대문자도 마찬가지 
     * 알파벳이 아닌 공백인 경우 그대로 반환시킨다. */
    
   
    /**
     * n만큼 밀면 반환되는 문자 메소드 따로 만들어보기
     * @param ch 전달받은 문자알파벳
     * @param n 전달받은 미는 횟수 
     * @return c 전달받은 문자에서 n만큼 밀면 나오는 문자알파벳 
     */
    private static char push(char ch, int n) {
    	// 아스키코드값을 이용해서 전달받은 문자에서 n만큼 밀어 나오는 알파벳 문자를 반환한다. 
    	char resultC = (char)(ch +n);  
    	
    	// 공백인 경우 그대로 다시 문자 반환 
    	if(!Character.isAlphabetic(ch)) {
    		return ch; 
    	}    	
    	// 대문자이면서 범위초과시 
    	else if(Character.isUpperCase(ch) && resultC > 'Z') {
    		return (char) (resultC -'Z' + 'A' -1);
    	}
    	
    	// 소문자이면서 범위초과시 
    	else if (resultC > 'z') {
    		
    		return (char) (resultC -'z' + 'a' -1);
    	} 
    	
    	return resultC; 
    }
    
	public static String solution(String s, int n) {
	    String answer = "";
	    StringBuilder sb = new StringBuilder();
	    // 문자열 => 문자 변환 
	    for(char ch : s.toCharArray()) {
	    	
	    	// 빌더에 
	    	sb.append(push(ch, n));
	    }	    
	    answer = sb.toString();
		return answer;
	}
	
	
	public static void main(String[] args) {
		System.out.println(solution(s1, n1));
		System.out.println(solution(s2, n2));
		System.out.println(solution(s3, n3));
	}
}
