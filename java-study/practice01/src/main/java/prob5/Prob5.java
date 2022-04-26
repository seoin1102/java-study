package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for(int num=1; num <= 99; num++) {
			String num2 = Integer.toString(num);
			if(num2.length() == 1 && num2.contains("3") || num2.length() == 1 && num2.contains("6") || num2.length() == 1 && num2.contains("9")) {
				System.out.print(num2);
				System.out.print(" ");
				System.out.print("짝");
				System.out.println("");
			}
			
			else if(num2.length() == 2) {
				if(num2.indexOf("3") == 0 || num2.indexOf("6") == 0 || num2.indexOf("9") == 0) {
					System.out.print(num2);
					System.out.print(" ");
					System.out.print("짝");
				if(num2.lastIndexOf("3") == 1 || num2.lastIndexOf("6") == 1 || num2.lastIndexOf("9") == 1) {
					System.out.print("짝");
						}System.out.println("");}
			else if(num2.indexOf("3") == 1 || num2.indexOf("6") == 1 || num2.indexOf("9") == 1) {
					System.out.print(num2);
					System.out.print(" ");
					System.out.print("짝");
				if(num2.lastIndexOf("3") == 0 || num2.lastIndexOf("6") == 0 || num2.lastIndexOf("9") == 0) {
					System.out.print("짝");
						}System.out.println("");}

			}

		}
	}
}
