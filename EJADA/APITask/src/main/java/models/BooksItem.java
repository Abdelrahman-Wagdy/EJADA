package models;

import com.google.gson.annotations.SerializedName;

public class BooksItem{

	@SerializedName("name")
	private String name;

	@SerializedName("available")
	private boolean available;

	@SerializedName("id")
	private int id;

	@SerializedName("type")
	private String type;

	public String getName(){
		return name;
	}

	public boolean isAvailable(){
		return available;
	}

	public int getId(){
		return id;
	}

	public String getType(){
		return type;
	}
}
