package com.goura.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClientExample {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://api.zenhub.io/v5/repositories/91506033/issues?epics=1&estimates=1");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Origin", "https://app.zenhub.com");
			con.setRequestProperty("x-authentication-token",
					"*****************");
			con.setRequestMethod("GET");

			System.out.println("Response code: " + con.getResponseCode());
			if (200 != con.getResponseCode()) {
				throw new RuntimeException("Error: HTTP code: " + con.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

			System.out.println("Output:\n");
			br.lines().forEach(System.out::println);

			con.disconnect();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
