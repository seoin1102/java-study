package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			int minNumber = 1;
			int maxNumber = 100;

			Random random = new Random();
			int correctNumber = random.nextInt(maxNumber) + minNumber;
			int countTry = 0;
			System.out.println("수를 결정하였습니다. 맞추어 보세요:");

			while (true) {
				/* 게임 작성 */
				countTry++;
				// 정답 램덤하게 만들기
				System.out.println(minNumber + "-" + maxNumber);

				System.out.println(countTry + ">>");

				int guessNumber = scanner.nextInt();

				if (guessNumber == correctNumber) {
					System.out.print("맞았습니다.");
					break;
				}
				if (guessNumber < correctNumber) {
					System.out.println("더 높게");
					minNumber = guessNumber;
				} else {
					System.out.println("더 낮게");
					maxNumber = guessNumber;
				}
				System.out.println("다시 하시겠습니까?(y/n)>>");
				String answer = scanner.next();
				if ("y".equals(answer.toLowerCase()) == false) {
					break;
				}
			}

		}
	}

}