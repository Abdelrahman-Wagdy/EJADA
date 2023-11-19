package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.*;

public class APIServices {
    public BooksItem[] getBooksList(){
        return RestAssured.get("https://simple-books-api.glitch.me/books").as(BooksItem[].class);
    }
    public BookDetails getBookDetails(int bookID){
        return RestAssured.get("https://simple-books-api.glitch.me/books/" + bookID).as(BookDetails.class);
    }
    public APIAuthenticationResponse getToken(APIAuthenticationPayload user){
        RestAssured.baseURI ="https://simple-books-api.glitch.me";
         Response response = RestAssured.given().header("Content-Type", "application/json")
                .body(user).post("/api-clients/");
         return response.as(APIAuthenticationResponse.class);

    }
    public OrderResponse orderBook(OrderPayload order, APIAuthenticationResponse authorization){
        RestAssured.baseURI ="https://simple-books-api.glitch.me";
        Response response = RestAssured.given().header("Content-Type", "application/json")
                .header("Authorization", authorization.getAccessToken())
                .body(order).post("/orders");
        return response.as(OrderResponse.class);
    }

    public OrderDetails getOrder(OrderResponse order, APIAuthenticationResponse authorization){
        RestAssured.baseURI ="https://simple-books-api.glitch.me";
        Response response = RestAssured.given().header("Authorization", authorization.getAccessToken())
                .get("/orders/"+ order.getOrderId());
        return response.as(OrderDetails.class);
    }
}
