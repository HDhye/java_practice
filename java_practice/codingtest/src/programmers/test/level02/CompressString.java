package programmers.test.level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 문자열 압축
 * "ababcdcdababcdcd"의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 
 * 2개 단위로 잘라서 압축한다면 "2ab2cd2ab2cd"로 표현할 수 있습니다. 
 * 다른 방법으로 8개 단위로 잘라서 압축한다면 "2ababcdcd"로 표현할 수 있으며, 
 * 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.
 * 			s					  result
 * "aabbaccc"						7
 * "ababcdcdababcdcd"				9
 * "abcabcdede"						8
 * "abcabcabcabcdededededede"		14
 * "xababcdcdababcdcd"				17
 * @since 20230606 ~ 
 * @author hdhye
 * @출처: 프로그래머스 코딩테스트 연습
 * {@link https://school.programmers.co.kr/learn/courses/30/lessons/60057}
 */
class CompressString {

	//이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다. 2abc2de
	
	/* String s = "ababcdcdcdababcdcd"; 일 때, 
	 * 1. 1 ~ length 개수로 잘랐을 경우의 수 반복 (1로 자른경우 그대로 length 반환됨) 
	 * 2. List<String> sublist2 = { ab, ab, cd, cd, cd, ab, cd, cd}.. 2개로 자른 문자열 
	 * 	2-1. s.substring(0,2),(2,4),(4,6) .... ( i*2, (length/2)*2)  
	 * 		 sublist2.add(s.substring())
	 * 	2-2. int count = 1; // 문자앞에 붙는 반복숫자 
	 * 4. Stringbuilder result += 반복숫자 + 문자열들 조합 
	 * 
	 * 	 4-1. if ( sublist2.get[i].equals(sublist2.get[j]) ) {    // 문자열이 같으면 count 숫자 올려주고 해당 문자열과 합침 (j > i) 
	 *               count++;    // 매번 반복시 1로 초기화 
	 *               sublist2[j].replace(j)
	 *               if(sublist2.get[i].equals[sublist2.get[j]) break; 
	 *       {   
	 *       sublist2.add(i)     
	 *       result += count + sublist2[i]; 

	 * 5. n개로 자른 경우 length는? result문자열들의 제일 짧은 length 반환   
	 * */
	
	public static int solution(String s) { 
		
		int answer = 0;
		StringBuilder sb = null; // 숫자와 문자열 합치기 
		
		List<String> sublist =null; // 
		List<Integer> countlist = null;
		
		
		oneStep: 
		for(int n = 1; n <= s.length(); n++) {
			
			sb = new StringBuilder(); 
			sublist = new ArrayList<>();
			countlist = new ArrayList<>();
			
			for (int i = 0; i < s.length()/n; i++) {
				
				sublist.add(s.substring(n*i, n*(i+1)));
			}
			
			for (int i = 0; i < sublist.size(); i++) {
				
				int count = 1; // i를 돌면서 1로 계속 초기화 
				
				twoStep: 
					for(int j = i+1; j < sublist.size(); j++ ) {
						
						if(sublist.get(i).equals(sublist.get(j))) {
							count++;
							sublist.set(j, j+"");
							sb.append(count + sublist.get(i));
							
						} else sb.append(count + sublist.get(i)); break twoStep;   // 다음 문자열이 같지 않으면 바로 다음 i원소 탐색 
					}
			}
			sb.append(sublist.get(sublist.size()-1));
			
			// sb에서 1은 삭제 
			System.out.println(sb.toString().replaceAll("1", "") + " : " + sb.length());
			countlist.add(sb.toString().replaceAll("1", "").length());
		}
		answer = (int)(countlist.stream().max((a, b) -> a)).get();
		return answer;
	}
	
	
	public static void main(String[] args) {
		
		String s = "abcab";
		
		System.out.println(solution(s));
		// 9
	}
	
	
	
	
}



