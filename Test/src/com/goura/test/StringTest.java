package com.goura.test;

public class StringTest {

	private static final String key_st = "${";
	private static final String key_end = "}";

	public static void main(String[] args) {
		String url = "${BUILD_URL}cobertura/${VALUE}";
		int startIndex = -1;
		int endIndex = 0;
		while (-1 != (startIndex = url.indexOf(key_st, endIndex))) {
			endIndex = url.indexOf(key_end, startIndex);
			String key = url.substring(startIndex + key_st.length(), endIndex);
			url = url.replace(key_st + key + key_end, getEnv(key));
		}
		System.out.println(url);
	}

	private static String getEnv(final String key) {
		switch (key) {
		case "BUILD_URL":
			return "http://34.211.195.192/job/CITest_Report/60/";

		case "VALUE":
			return "55";

		default:
			return null;
		}
	}
}
