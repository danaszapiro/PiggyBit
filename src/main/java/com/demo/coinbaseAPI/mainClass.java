package com.demo.coinbaseAPI;

import java.io.IOException;

public class mainClass {

	public static void main(String[] args) throws IOException {
		PriceFetcher test = new PriceFetcher();
		System.out.println(test.getRequest());
		

	}

}
