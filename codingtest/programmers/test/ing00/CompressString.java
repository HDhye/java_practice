package programmers.test.ing00;

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
 * @since 20230528 ~ 
 * @author hdhye
 * @출처: 프로그래머스 코딩테스트 연습
 * {@link https://school.programmers.co.kr/learn/courses/30/lessons/60057}
 */
public class CompressString {

	//이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다. 2abc2de
	
	/* 
	 * 1~n까지 잘랐을 경우의 수를 반복 
	 * 0번 인덱스부터 n-1번 인덱스까지 단어를 (1n ~ n*2-1)에서 찾고, 중복문자열이면 지우고(변경되어야 함) 카운트 +1을 해준다. 
	 * (jn ~ n*i-1) 반복 순차 탐색시작하여 없는 경우, 1번 인덱스부터 n번 인덱스까지 똑같은 과정을 다시 시작
	 * n을 증가시켜 반복한다.
	 * 가장 작은 문자열길이의 값을 최종 반환한다.  
	 * */
}
