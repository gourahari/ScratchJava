package com.goura.test.interview;

public class Find2IntegersMultiplied20 {

	public static void main(String[] args) {
		int[] data = new int[] {2, 4, 5, 7, 9, 10, 15, 17, 18};

		int product = 20;
		int m = -1, n = -1;

		for (int i = 0; n == -1 && i < data.length - 1; i++) {
			if (0 == data[i]) {
				continue;
			}
			for (int j = i + 1; data[j] <= (product / data[i]) && j < data.length; j++) {
				if (data[j] == (product / data[i])) {
					m = i;
					n = j;
					break;
				}
			}
		}

		System.out.println(m + " " + n);
	}

}
