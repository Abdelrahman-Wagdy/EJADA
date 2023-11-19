package models;

import com.google.gson.annotations.SerializedName;

public class OrderResponse{

	@SerializedName("orderId")
	private String orderId;

	@SerializedName("created")
	private boolean created;

	public String getOrderId(){
		return orderId;
	}

	public boolean isCreated(){
		return created;
	}
}