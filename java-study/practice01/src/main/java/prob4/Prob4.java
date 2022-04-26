package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		int len = text.length();
		int num = 0;
		for(; len > num; num++) {
			System.out.println(text.substring(0,num+1));
			}
		}

	
	}

