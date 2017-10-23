package com.demo.coinbaseAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PriceFetcher {

	private static final String API_KEY = "FZ8tws1OvtOlzxQ6";
	private static final String API_SECRET = "qwykxzTDXIMGeQeODQQYR9BA6vKX9mGN";
	private static final String EXCHANGE_URL = "https://api.coinbase.com/v2/exchange-rates?currency=";
	
	static String getRequest(String crypto) throws IOException{
		URL url = new URL(EXCHANGE_URL + crypto);
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
	
	static String processJSON(String crypt, String curr) throws IOException, ParseException {
		String input = getRequest(crypt);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(input);
		JSONObject data = (JSONObject) json.get("data");
		JSONObject rates = (JSONObject) data.get("rates");
		String found = (String) rates.get(curr);
		
		return found;
		
	}
}
