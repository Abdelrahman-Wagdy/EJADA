package services.login;

import browseractions.BrowserActions;

public class LoginPageServices {
    protected final BrowserActions browserActions = new BrowserActions();
    private String USERNAME_FIELD;
    private String PASSWORD_FIELD;
    private String LOGIN_BUTTON_FIELD;
    private String CART_FIELD;
    private String FAILURE_MESSAGE_FIELD;
    public LoginPageServices(){
        USERNAME_FIELD = System.getProperty("username.field");
        PASSWORD_FIELD = System.getProperty("password.field");
        LOGIN_BUTTON_FIELD = System.getProperty("login.button");
        CART_FIELD = System.getProperty("cart.field");
        FAILURE_MESSAGE_FIELD = System.getProperty("failure.message.field");
    }

    public void navigateToWebsite(){
        browserActions.navigateToURL();
    }
    public void enterUsername(String username){
        browserActions.fillData(USERNAME_FIELD, BrowserActions.TypeOfElement.ID, username);
    }
    public void enterPassword(String password){
        browserActions.fillData(PASSWORD_FIELD, BrowserActions.TypeOfElement.ID, password);
    }
    public void login(){
        browserActions.click(LOGIN_BUTTON_FIELD, BrowserActions.TypeOfElement.ID);
    }
    public Boolean cartElementIsDisplayed(){
        return browserActions.getElement(CART_FIELD, BrowserActions.TypeOfElement.ID).isDisplayed();
    }
    public void validLogin(){
        navigateToWebsite();
        enterUsername("standard_user");
        enterPassword("secret_sauce");
        login();
    }
    public String loginFailure(){
        return browserActions.getElement(FAILURE_MESSAGE_FIELD, BrowserActions.TypeOfElement.CSS_SELECTOR).getText();
    }
}
