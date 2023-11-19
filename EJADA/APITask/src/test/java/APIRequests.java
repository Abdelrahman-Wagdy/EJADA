import models.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.APIServices;

public class APIRequests {
    final String CUSTOMER_NAME = "Abdelrahman Wagdy";
    final String CUSTOMER_EMAIL = "abdelrahman@wagdy.com";
    APIServices apiServices;
    APIAuthenticationPayload user;
    APIAuthenticationResponse authentication = null;

    @BeforeClass
    public void createUser(){
        apiServices = new APIServices();
        user = new APIAuthenticationPayload();
        user.setClientName(CUSTOMER_NAME);
        user.setClientEmail(CUSTOMER_EMAIL);
        authentication = apiServices.getToken(user);
    }

    @Test
    public void validateThatTheListOfBooksIsReturnedSuccessfully(){
        BooksItem[] booksList = apiServices.getBooksList();
        int bookID = booksList[0].getId();
        BookDetails book1 = apiServices.getBookDetails(bookID);
        Assert.assertEquals(book1.getAuthor(), "James Patterson and James O. Born");
        Assert.assertTrue(book1.isAvailable());
    }
    @Test
    public void validateThatTheBookIsOrderedSuccessfully(){
        BooksItem[] booksList = apiServices.getBooksList();
        int bookID = booksList[2].getId();

        OrderPayload order = new OrderPayload();
        order.setBookId(bookID);
        order.setCustomerName(CUSTOMER_NAME);

        OrderResponse orderResponse = apiServices.orderBook(order, authentication);
        Assert.assertTrue(orderResponse.isCreated());
        Assert.assertNotNull(orderResponse.getOrderId());

        OrderDetails orderDetails = apiServices.getOrder(orderResponse, authentication);
        Assert.assertEquals(orderDetails.getCustomerName(), CUSTOMER_NAME);
        Assert.assertEquals(orderDetails.getBookId(), bookID);
        Assert.assertEquals(orderDetails.getQuantity(), 1);
        Assert.assertEquals(orderDetails.getId(), orderResponse.getOrderId());
        Assert.assertNotNull(orderDetails.getCreatedBy());
        Assert.assertNotNull(orderDetails.getTimestamp());
    }
}
