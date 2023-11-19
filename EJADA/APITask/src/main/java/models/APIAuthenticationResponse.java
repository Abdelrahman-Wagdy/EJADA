package models;

import com.google.gson.annotations.SerializedName;

public class APIAuthenticationResponse{

	@SerializedName("accessToken")
	private String accessToken;

	public String getAccessToken(){
		return accessToken;
	}
}