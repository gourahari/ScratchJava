package com.goura.test.interview;

public class FindDuplicateElementsTest {

	public static void main(String[] args) {
		int[] array = new int[] {1, 6, 9, 2, 5, 1, 5, 8, 2, 5, 9, 4, 6, 2, 5, 8, 2, 1, 6, 9, 0, 3};

		int item = -1;
		for (int i = 0; i < array.length; i++) {
			item = array[i];
			System.out.printf("Duplicate of %d found at position: ", item);
			for (int j = i + 1; j < array.length; j++) {
				if (item == array[j]) {
					System.out.printf("%d, ", j);
				}
			}
			System.out.println();
		}
	}

}
