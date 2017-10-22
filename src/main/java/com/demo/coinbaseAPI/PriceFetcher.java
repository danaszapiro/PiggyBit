package com.demo.coinbaseAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PriceFetcher {
	
	public static String crypto = "ETH";
	public static String currency = "USD";
	private static final String API_KEY = "FZ8tws1OvtOlzxQ6";
	private static final String API_SECRET = "qwykxzTDXIMGeQeODQQYR9BA6vKX9mGN";
	private static final String EXCHANGE_URL = "https://api.coinbase.com/v2/exchange-rates?currency=" + crypto;
	
	static String getRequest() throws IOException{
		URL url = new URL(EXCHANGE_URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		int respCode = conn.getResponseCode();
		System.out.println("GET Response Code :: " + respCode);
		if (respCode == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			StringBuffer read = new StringBuffer();
			while((line = br.readLine()) != null) {
				read.append(line);
			}
			br.close();
			return read.toString();
		} else {
			System.out.println("GET request not worked");
		}
		return null;
		
	}
}
