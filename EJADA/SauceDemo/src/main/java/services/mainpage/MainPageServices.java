package services.mainpage;

import browseractions.BrowserActions;
import services.login.LoginPageServices;

public class MainPageServices extends LoginPageServices {
    private String ITEM1_FIELD;
    private String ITEM2_FIELD;
    private String ITEMS_IN_CART_FIELD;
    private String CART_FIELD;
    public MainPageServices(){
        ITEM1_FIELD = System.getProperty("item.fleece.jacket");
        ITEM2_FIELD = System.getProperty("item.backpack");
        ITEMS_IN_CART_FIELD = System.getProperty("items.in.cart");
        CART_FIELD = System.getProperty("cart.field");
    }
    public void selectItem1(){
        browserActions.click(ITEM1_FIELD, BrowserActions.TypeOfElement.CSS_SELECTOR);
    }
    public void selectItem2(){
        browserActions.click(ITEM2_FIELD, BrowserActions.TypeOfElement.CSS_SELECTOR);
    }
    public String numberOfItemsInCart(){
        return browserActions.getElement(ITEMS_IN_CART_FIELD, BrowserActions.TypeOfElement.XPATH).getText();
    }
    public void goToCart(){
        browserActions.click(CART_FIELD, BrowserActions.TypeOfElement.ID);
    }

}
