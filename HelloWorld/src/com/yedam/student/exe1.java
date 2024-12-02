package com.yedam.student;

public class exe1 {
	public static void main(String[] args) {
		int[] intAry = { 50, 67, 94, 83, 45 };
		for (int j = 0; j < intAry.length - 1; j++) {
			for (int i = 0; i < intAry.length - 1; i++) {
				// 순번변경. 배열크기 -1 반복.
				if (intAry[i] < intAry[i + 1]) {
					// i 위치 -> i + 1 위치, i + 1 위치 -> i위치.
					int temp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = temp;
				}
			}
		}
		for (int num : intAry)
			System.out.println(num);
		
		Student[] storage = { new Student(), new Student() };
		if (storage[0].studentEng + storage[0].studentMath > storage[1].studentEng + storage[1].studentMath) {
			Student temp = storage[0];
			storage[0] = storage[1];
			storage[1] = temp;			
		}
	}
}
