package services.checkout;

import browseractions.BrowserActions;
import services.mainpage.MainPageServices;

public class CheckoutPageServices extends MainPageServices {
    private String PAGE_TITLE_FIELD;
    private String FIRST_NAME_FIELD;
    private String LAST_NAME_FIELD;
    private String POSTAL_CODE_FIELD;
    private String CONTINUE_BUTTON_FIELD;
    private String TOTAL_PRICE_BEFORE_TAX_FIELD;
    private String FINISH_BUTTON_FIELD;
    private String THANK_YOU_MESSAGE_FIELD;
    private String ORDER_DISPATCHED_MESSAGE_FIELD;
    public CheckoutPageServices(){
        PAGE_TITLE_FIELD = System.getProperty("page.title.field");
        FIRST_NAME_FIELD = System.getProperty("first.name.field");
        LAST_NAME_FIELD = System.getProperty("last.name.field");
        POSTAL_CODE_FIELD = System.getProperty("postal.code.field");
        CONTINUE_BUTTON_FIELD = System.getProperty("continue.button.field");
        TOTAL_PRICE_BEFORE_TAX_FIELD = System.getProperty("total.price.before.tax.field");
        FINISH_BUTTON_FIELD = System.getProperty("finish.button.field");
        THANK_YOU_MESSAGE_FIELD = System.getProperty("thank.you.message.field");
        ORDER_DISPATCHED_MESSAGE_FIELD = System.getProperty("order.dispatched.message.field");
    }
    public String getCheckoutPageTitle(){
        return browserActions.getElement(PAGE_TITLE_FIELD, BrowserActions.TypeOfElement.CLASSNAME).getText();
    }
    public void enterFirstNameInForm(String firstName){
        browserActions.fillData(FIRST_NAME_FIELD, BrowserActions.TypeOfElement.CSS_SELECTOR, firstName);
    }
    public void enterLastNameInForm(String lastName){
        browserActions.fillData(LAST_NAME_FIELD, BrowserActions.TypeOfElement.CSS_SELECTOR, lastName);
    }
    public void enterPostCodeInForm(String postalCode){
        browserActions.fillData(POSTAL_CODE_FIELD, BrowserActions.TypeOfElement.CSS_SELECTOR, postalCode);
    }
    public void clickTheContinueButton(){
        browserActions.click(CONTINUE_BUTTON_FIELD, BrowserActions.TypeOfElement.CSS_SELECTOR);
    }
    public String getTotalAmountBeforeTax(){
        return browserActions.getElement(TOTAL_PRICE_BEFORE_TAX_FIELD, BrowserActions.TypeOfElement.CLASSNAME).getText();
    }
    public String getCheckoutPageUrl(){
        return browserActions.getURL();
    }
    public void clickTheFinishButton(){
        browserActions.click(FINISH_BUTTON_FIELD, BrowserActions.TypeOfElement.CSS_SELECTOR);
    }
    public String getThankYouMessage(){
        return browserActions.getElement(THANK_YOU_MESSAGE_FIELD, BrowserActions.TypeOfElement.CLASSNAME).getText();
    }
    public String getOrderPlacedMessaged(){
        return browserActions.getElement(ORDER_DISPATCHED_MESSAGE_FIELD, BrowserActions.TypeOfElement.CLASSNAME)
                .getText();
    }
}
