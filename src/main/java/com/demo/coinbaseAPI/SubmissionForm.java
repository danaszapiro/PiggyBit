package com.demo.coinbaseAPI;

public class SubmissionForm {

    private String currency;
    private String crypto;
    private String price;
    
    public SubmissionForm(String currency, String crypto, String price) {
        this.currency = currency;
        this.crypto = crypto;
        this.price = price;
    }
    
	public SubmissionForm() {
		// TODO Auto-generated constructor stub
	}

	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCrypto() {
		return crypto;
	}
	public void setCrypto(String crypto) {
		this.crypto = crypto;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


}