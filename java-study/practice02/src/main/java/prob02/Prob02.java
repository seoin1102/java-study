package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        int intArray[] = new int[5];
        double sum = 0;

        System.out.println("5개의 숫자를 입력하세요.");
		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		for(int i=0; i < intArray.length; i++) {
			int num = in.nextInt();
		/* 배열에 저장된 정수 값 더하기 */
			sum += num;
		}
		
		
		
		/* 출력 */
		System.out.printf("평균은 %.1f 입니다.",sum/5);
		
		/* 자원정리 */

	}
}
