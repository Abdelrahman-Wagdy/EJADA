package models;

import com.google.gson.annotations.SerializedName;

public class OrderPayload{

	@SerializedName("customerName")
	private String customerName;

	@SerializedName("bookId")
	private int bookId;

	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}

	public String getCustomerName(){
		return customerName;
	}

	public void setBookId(int bookId){
		this.bookId = bookId;
	}

	public int getBookId(){
		return bookId;
	}
}