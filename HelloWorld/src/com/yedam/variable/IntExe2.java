package com.yedam.variable;

public class IntExe2 {
	public static void main(String[] args) {
		// 정수형 -> byte(1바이트), short(2바이트), int(4바이트),
		// long(8바이트), char(2바이트)
		// 1비트 * 8 = 1바이트.
		byte b1 = 100;
		byte b2 = 100;
		int result = (int) b1 + (int) b2; // 형변환(casting)
		
		byte result2 = (byte) (b1 + b2);
		System.out.print(result2);
		
		for(int i = 0; i < 100; i++) {
			System.out.print("b1의 값 " + b1++);
		}
		System.out.println(Integer.MAX_VALUE);
		long l1 = 10000000000L;
		
		// float(4바이트), double(8바이트)
		// 0 ~ 1 사이의 모든 값 
		double d1 = 0.1;
		double d2 = 0.2;
		double result3 = d1 + d2;
		
		System.out.println("result3 의 값은 " + Math.floor(result3 * 10) / 10);
		
		double[] doubleAry = { 10, 23.4, 11.7, 34.5 };
		// doubleAry의 합은 78.4 입니다.
		double sum = doubleAry[0] + doubleAry[1] + doubleAry[2] + doubleAry[3];
		System.out.println("doubleAry의 합은 " + sum);
	}
}
