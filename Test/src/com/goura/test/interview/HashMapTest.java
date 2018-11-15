package com.goura.test.interview;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		String[] names = new String[] {"Goura", "Gita", "Gautam", "John"};
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < names.length; i++) {
			map.put("Key" + i, names[i]);
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(i + ". " + map.get("Key" + i));
		}
	}

}
