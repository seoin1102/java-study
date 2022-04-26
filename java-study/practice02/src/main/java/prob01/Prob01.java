package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		int[] CHANGE = new int[10];
		/* 코드 작성 */
		int money = scanner.nextInt();
		for(int i = 0; i < MONEYS.length; i++) {
			if(MONEYS[i] < money) {
				CHANGE[i] = money / MONEYS[i];

				money = money - (CHANGE[i] * MONEYS[i]);
				System.out.printf("%d원 : %d개%n",MONEYS[i],CHANGE[i]);
			}
		}
		scanner.close();
 	}
}