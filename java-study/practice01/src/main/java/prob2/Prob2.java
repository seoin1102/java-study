package prob2;

import java.util.Scanner;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		int num =1;
		for(int cnt2 =0; cnt2 <9; cnt2++) {
			for(int cnt =0; cnt <10; cnt++) {
				System.out.print(num++);
			}
			System.out.println();
			num = num -9;	
		}
	}
}
