package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		int sum =  0;
		int num = 0;
		System.out.print("수를 입력하세요:");
		int number = scanner.nextInt();
		if (number % 2 ==1) {
			num = 1;
			sum = 1;
		}
		for(; num < number;) {
			num +=2;
			sum += num;
			}
		
		System.out.print("결과 값 : ");
		System.out.println(sum);
		
		
		scanner.close();
	}
}
