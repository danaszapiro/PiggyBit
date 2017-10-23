package com.demo.coinbaseAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class mainClass {
	public static String crypto = "ETH";
	public static String currency = "USD";

    public static void main(String[] args) {
        SpringApplication.run(mainClass.class, args);
    }
/*
	public static void main(String[] args) throws IOException, ParseException {
		System.out.println(PriceFetcher.getRequest());
		String price = PriceFetcher.processJSON(crypto, currency);
		System.out.println("Cryptocurrency requested: " + crypto);
		System.out.println("Price for " + crypto + " in " + currency + " is " + price);
	}
	*/

}