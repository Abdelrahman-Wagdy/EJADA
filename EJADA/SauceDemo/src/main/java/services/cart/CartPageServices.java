package services.cart;

import browseractions.BrowserActions;
import org.openqa.selenium.WebElement;
import services.mainpage.MainPageServices;

import java.util.ArrayList;
import java.util.List;

public class CartPageServices extends MainPageServices {
    private String CART_ITEMS_FIELD;
    private String CHECKOUT_BUTTON_FIELD;
    private String PAGE_TITLE_FIELD;
    public CartPageServices(){
        CART_ITEMS_FIELD = System.getProperty("cart.items.field");
        CHECKOUT_BUTTON_FIELD = System.getProperty("checkout.button.field");
        PAGE_TITLE_FIELD = System.getProperty("page.title.field");
    }
    public String getCartPage(){
        return browserActions.getElement(PAGE_TITLE_FIELD, BrowserActions.TypeOfElement.CLASSNAME).getText();
    }
    public List<String> getCartItems(){
        List<WebElement> cartItems = browserActions.getElements(CART_ITEMS_FIELD, 
                BrowserActions.TypeOfElement.CLASSNAME);
        List<String> cartItemsName = new ArrayList<String>();
        for (WebElement cartItem:cartItems) {
            cartItemsName.add(cartItem.getText());
        }
        return cartItemsName;
    }
    public void proceedToCheckout(){
        browserActions.click(CHECKOUT_BUTTON_FIELD, BrowserActions.TypeOfElement.CSS_SELECTOR);
    }
}
