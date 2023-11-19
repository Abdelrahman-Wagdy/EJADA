package models;

import com.google.gson.annotations.SerializedName;

public class BookDetails{

	@SerializedName("current-stock")
	private int currentStock;

	@SerializedName("author")
	private String author;

	@SerializedName("price")
	private Object price;

	@SerializedName("isbn")
	private String isbn;

	@SerializedName("name")
	private String name;

	@SerializedName("available")
	private boolean available;

	@SerializedName("id")
	private int id;

	@SerializedName("type")
	private String type;

	public int getCurrentStock(){
		return currentStock;
	}

	public String getAuthor(){
		return author;
	}

	public Object getPrice(){
		return price;
	}

	public String getIsbn(){
		return isbn;
	}

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