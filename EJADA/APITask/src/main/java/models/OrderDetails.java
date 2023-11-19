package models;

import com.google.gson.annotations.SerializedName;

public class OrderDetails{

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("createdBy")
	private String createdBy;

	@SerializedName("id")
	private String id;

	@SerializedName("customerName")
	private String customerName;

	@SerializedName("bookId")
	private int bookId;

	@SerializedName("timestamp")
	private long timestamp;

	public int getQuantity(){
		return quantity;
	}

	public String getCreatedBy(){
		return createdBy;
	}

	public String getId(){
		return id;
	}

	public String getCustomerName(){
		return customerName;
	}

	public int getBookId(){
		return bookId;
	}

	public long getTimestamp(){
		return timestamp;
	}
}