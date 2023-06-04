package programmers.test.level01;


/**
 * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
 * 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
 * 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 * 
 * 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
 * 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
 * @since 20230528 ~ 20230528 풀이 완료 
 * @author hdhye
 * @출처 : 프로그래머스 코팅테스트 연습
 * {@link https://school.programmers.co.kr/learn/courses/30/lessons/12930}
 */
public class WeirdCharaters {
	private static final String s = "try hello world";
	
	public static String solution(String s) {
        String answer = "";
        
        /* 풀이방법 
         * 1. 각 단어를 문자 배열로 만든다. 
         * 2. 각 단어를 돌면서 처음과 짝수인덱스는 대문자, 홀수인덱스는 소문자로 변환한다. => upperCase, lowerCase 사용 
         * 3. true인 경우 대문자, false인 경우 소문자로 변환되게 검증값을 조건문에 추가한다.
         * 4. 공백은 그대로 반영시킨다.  
         * */ 
        
        
        boolean upperCase = true;  // 앞인덱스 문자가 대문자인지 아닌지 판단하는 기준 
        // 문자배열로 만들어서 한글자씩 검증한다. 
        for(char c : s.toCharArray()) {
        	// 공백인 경우 문자열에 그대로 추가한다. 
        	if(!Character.isAlphabetic(c)) {
        		answer += c; 
        		upperCase = false;  // 검증값이 최종 false가 되어야 다음 문자가 대문자가 되므로 앞에서 한번 더 true를 시켜둔다.  
        		
        	} else {
        		// 첫인덱스는 무조건 대문자여야 하므로 true롤 주고, 문자를 대문자로 변환하여 추가시킨다. 
        		if(upperCase) {
        			answer += Character.toUpperCase(c);
        			// 검증값이 false인 경우 소문자로 변환하여 추가한다. 
        		} else {
        			answer += Character.toLowerCase(c);
        		}
        	}
        	// 문자 하나를 추가할 때마다 검증값을 전환시킨다. 			
        	upperCase = !upperCase;
        }
        	return answer;
    }
	
	
	
	public static void main(String[] args) {
		
		System.out.println(solution(s));
		// ==> "TrY HeLl WoRlD"
	}

}
