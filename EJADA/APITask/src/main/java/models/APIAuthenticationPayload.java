package models;

import com.google.gson.annotations.SerializedName;

public class APIAuthenticationPayload{

	@SerializedName("clientName")
	private String clientName;

	@SerializedName("clientEmail")
	private String clientEmail;

	public void setClientName(String clientName){
		this.clientName = clientName;
	}

	public String getClientName(){
		return clientName;
	}

	public void setClientEmail(String clientEmail){
		this.clientEmail = clientEmail;
	}

	public String getClientEmail(){
		return clientEmail;
	}
}