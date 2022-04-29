package prob1;

public class Sort {
	
	public static void main(String[] arg) {
	
		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int count =  array.length;
		
		System.out.println( "Before sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print( array[ i ] + " " );
		}
		
		//
		// 정렬 알고리즘이 적용된 코드를 여기에 작성합니다.
		//
		
		int j = 0;
		while(true) {
			if(array[j] < array[j+1]) {
				int temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				j = 0;
			}
			else if(array[j] > array[j+1]) {
				j++;
			}
			if(j == count-1) {
				break;
			}
		}

		
		// 결과 출력
		System.out.println( "\nAfter Sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}		
	}
}