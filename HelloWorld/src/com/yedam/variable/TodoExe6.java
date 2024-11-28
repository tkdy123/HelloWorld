package com.yedam.variable;

public class TodoExe6 {
	public static void main(String[] args) {
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
