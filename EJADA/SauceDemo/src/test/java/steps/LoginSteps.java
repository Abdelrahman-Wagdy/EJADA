package steps;

import browseractions.BrowserActions;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import services.login.LoginPageServices;

public class LoginSteps {
    final String VALID_USERNAME_DATA = "standard_user";
    final String VALID_PASSWORD_DATA = "secret_sauce";
    LoginPageServices loginPageServices = new LoginPageServices();
    @Given("I navigate to the website")
    public void iNavigateToTheWebsite() {
        loginPageServices.navigateToWebsite();
    }

    @Given("that the user enters a valid user name")
    public void thatTheUserEntersAValidUserName() {
        loginPageServices.enterUsername(VALID_USERNAME_DATA);
    }

    @And("the user enters a valid password")
    public void theUserEntersAValidPassword() {
        loginPageServices.enterPassword(VALID_PASSWORD_DATA);
    }

    @Then("the user log in successfully")
    public void theUserLogInSuccessfully() {
        loginPageServices.login();
        Assert.assertTrue(loginPageServices.cartElementIsDisplayed());
    }
    @Given("User navigates to the website")
    public void userNavigatesToTheWebsite() {
        loginPageServices.navigateToWebsite();
    }

    @Then("the user fails to login")
    public void theUserFailsToLogin() {
        loginPageServices.login();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPageServices.loginFailure(), expectedMessage);
    }
    @Given("that the user enters invalid {string}")
    public void thatTheUserEntersInvalid(String username) {
        loginPageServices.enterUsername(username);
    }

    @And("the user enters an invalid {string}")
    public void theUserEntersAnInvalid(String password) {
        loginPageServices.enterPassword(password);
    }

}

