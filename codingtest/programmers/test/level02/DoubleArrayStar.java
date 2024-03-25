package programmers.test.level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @since 20230515 풀이 완료
 * @author hdhye
 * @출처: 프로그래머스 코딩테스트 연습
 * {@link https://school.programmers.co.kr/learn/courses/30/lessons/87377}
 */
public class DoubleArrayStar {

	// commit test 1
	 
	private static class Point {
		
		public final long x;
		public final long y; 
		// 2. x, y의 정수 좌표를 담을 변수를 생성자를 통해 생성한다.  
		private Point(long x, long y) {
			this.x = x; 
			this.y = y; 
			//  교점좌표 
		}
	}
	

	/**
	 * 두 직선의 교점(x, y) 좌표를 구하는 방정식
	 * 직선 1: a1x + b1y + c1 = 0 
	 * 직선 2: a2x + b2y + c2 = 0 
	 * @param a1 
	 * @param b1
	 * @param c1
	 * @param a2
	 * @param b2
	 * @param c2
	 * @return 두 직선 교점  중 정수인 (x, y)의 좌표 
	 */
	public static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
		// 3. x,y,c의 교점의 좌표를 구하는 방정식 메소드를 만든다. 
		
		double x = (double)(b1*c2 - b2*c1)/(a1*b2 - a2*b1); 
		double y = (double)(a2*c1 - a1*c2)/(a1*b2 - a2*b1); 
		
		// 정수가 아닌 경우 null값 반환
		if(x % 1 != 0 || y % 1 != 0) {
			return null; 
		}
		// 정수인 경우의 좌표만 생성자를 통해 생성한다. 
		return new Point((long)x, (long)y); 
	}
	
	/**
	 * 최대값으로 이루어진 좌표
	 * @param points 모든 교점 좌표 리스트
	 * @return 좌표중 제일 x와 y의 최대값 
	 */
	private static Point getMaximumPoint(List<Point> points) {
		
		long x = Long.MIN_VALUE; 
		long y = Long.MIN_VALUE; 
		
		for(Point p : points) {
			if(p.x > x) x = p.x;
			if(p.y > y) y = p.y; 
		}
		// 
		return new Point(x, y); 
	}
	
	/**
	 * 최소값으로 이루어진 좌표 
	 * @param points 모든 교점 좌표 리스트 
	 * @return 좌표중 제일 x와 y의 최소값 
	 */
	private static Point getMinimumPoint(List<Point> points) {
		// 11*11 size 0~10 

		long x = Long.MAX_VALUE; // long의 범위 중 최대값으로 초기화한거임(초기값과 비교해서 작은 경우 작은 x로 계속 덮어쓸 것 )
		long y = Long.MAX_VALUE; // 초기화 
		
		for(Point p : points) {
			if(p.x < x) x = p.x;
			if(p.y < y) y = p.y; 
		}
		return new Point(x, y); 
	}

	
	public static void main(String[] args) {
		
		// 1. 문제 line이 주어진다.
		int[][] line = new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		
		// 2. x, y가 정수로 이루어진 좌표를 담을 리스트 변수를 생성한다.  
		List<Point> points = new ArrayList<>();	
		
		// 3. for문을 돌며 교점을 구한다. 
		for(int i = 0; i < line.length; i++ ) {
			for(int j =i+1; j < line.length; j++) {
				// line[]은 i+1개의 직선 배열들로  이루어져있다. line[][]의 각 인덱스는 {a, b, c}로 길이가 3이다. 
				// 직선 1: a1x + b1y + c1 = 0, 직선 2: a2x + b2y + c2 = 0 
				// line[i]와 line[i+1]의 교점을 구하는 메소드를 호출한다. 
				Point intersection = intersection(line[i][0], line[i][1], line[i][2], 
												  line[j][0], line[j][1], line[j][2]);
				
				// null이 아닌 경우 생성한 리스트에  정수 교점 좌표를 담는다. 
				if(intersection != null) {
					points.add(intersection); 
				}
			}
		}		
			// 별찍기 배열의 크기 
			Point minimum = getMinimumPoint(points);
			Point maximum = getMaximumPoint(points);
			
			// 구해진 최대최소값으로 배열크기 생성 
			int height = (int)(maximum.y - minimum.y + 1);
			int width = (int)(maximum.x - minimum.x + 1);
			
			char[][] arr = new char[height][width]; 
			
			// 모든 좌표에 . 찍기 
			for(char[] row : arr) {
				Arrays.fill(row, '.');
			} 
			// 교점좌표 인덱스로 변환시킨 후 별 찍기 
			for(Point p : points) {
				int x = (int)(p.x - minimum.x); // -4 - -4 =0
				int y = (int)(maximum.y - p.y); // 4 - -4 = 8 
				arr[y][x] = '*';
			}
			
			// 2차원 문자배열 1차원 문자열배열로 변환하기
			String[] answer = new String[arr.length];
			for(int i = 0; i < answer.length; i++) {
				answer[i] = new String(arr[i]);
			}
			for(String s : answer) {
				System.out.print(s);
				System.out.println();
			}
	}

}



