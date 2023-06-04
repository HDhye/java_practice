package programmers.test.level02;

import java.util.Arrays;

/**
 * 행렬의 곱셈
 * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
 * @since 20230522 풀이 완료 
 * @author hdhye
 * @출처: 프로그래머스 코딩테스트 연습
 * {@link https://school.programmers.co.kr/learn/courses/30/lessons/12949#}
 */
public class MultiplicationMatrix {
	
public static void main(String[] args) {
		
		Solution solution = new Solution();
		Issue issue = new Issue(); 

		
		int[][] answer1 = solution.solution(issue.getCase1arr1(), issue.getCase1arr2());
		System.out.println(Arrays.deepToString(answer1));
		// 2차원 배열의 출력은 Arrays클래스의 deepToString 메소드를 사용한다. 
		// [[15, 15], [15, 15], [15, 15]]
		
		int[][] answer2 = solution.solution(issue.getCase2arr1(), issue.getCase2arr2());
		System.out.println(Arrays.deepToString(answer2));
		// [[22, 22, 11], [36, 28, 18], [29, 20, 14]]
		
	}

}


class Solution {
	
	int[][] answer = {};

	public int[][] solution(int[][] arr1, int[][] arr2){
		
		// 행렬의 곱셈 배열의 길이 
		answer = new int[arr1.length][arr2[0].length];
		
		/* 
		 * answer[][] = 
		 * a[0][0]*b[0][0] + a[0][1]*b[1][0] = answer[0][0]
		 * a[0][0]*b[0][1] + a[0][1]*b[1][1] = answer[0][1]
		 * a[1][0]*b[0][0] + a[1][1]*b[1][0] = answer[1][0]
		 * a[1][0]*b[0][1] + a[1][1]*b[1][1] = answer[1][1]
		 * ....
		 * */
		
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				answer[i][j] = 0; 
				
				for (int k = 0; k < arr1[i].length; k++) {
					answer[i][j] += arr1[i][k]*arr2[k][j]; 
				}
			}
		}		
		return answer;
	}
	@Override
	public String toString() {
		return "Solution [answer=" + Arrays.toString(answer) + "]";
	}
}


/**
 * 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
 * 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
 * 곱할 수 있는 배열만 주어집니다
 */
class Issue{
	
	private final int[][] case1arr1 = {{1, 4}, {3, 2}, {4, 1}};
	private final int[][] case1arr2 = {{3,3}, {3,3}}; 
	
	private final int[][] case2arr1 = {{2,3,2},{4,2,4},{3,1,4}};
	private final int[][] case2arr2 = {{5,4,3},{2,4,1},{3,1,1}};
	public Issue() {
	}
	public int[][] getCase1arr1() {
		return case1arr1;
	}
	public int[][] getCase1arr2() {
		return case1arr2;
	}
	public int[][] getCase2arr1() {
		return case2arr1;
	}
	public int[][] getCase2arr2() {
		return case2arr2;
	}
	
	
}
