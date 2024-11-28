package com.yedam.variable;

public class TodoExe5 {
	public static void main(String[] args) {
		// 1번. 1에서 100까지의 정수 중 3의 배수의 합을 구하고 출력.
		int sum = 0;
		for (int i = 1; i <= 100;  i++) {
			if (i % 3 == 0) {
				sum = sum + i;
			}
		}
		System.out.println(sum);				
		
		//    *
		//   **
		//  ***
		// ****
		//*****
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= 5; j++) {
				// _____*
				if (j >= i) {   //   (1,2,3,4,5 >= 5)
					System.out.printf("*");					
				} else {
					System.out.printf(" ");
				}
			}
			System.out.println();
		}
	}
}
