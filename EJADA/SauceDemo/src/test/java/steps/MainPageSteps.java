package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import services.cart.CartPageServices;
import services.checkout.CheckoutPageServices;
import services.mainpage.MainPageServices;

import java.util.ArrayList;
import java.util.List;

public class MainPageSteps {
    final MainPageServices mainPageServices = new MainPageServices();
    final CartPageServices cartPageServices = new CartPageServices();
    final CheckoutPageServices checkoutPageServices = new CheckoutPageServices();
    @Given("the user chooses the two most expensive products")
    public void theUserChoosesTheTwoMostExpensiveProducts() {
        mainPageServices.selectItem1();
        mainPageServices.selectItem2();
    }

    @And("the user adds the products to the cart")
    public void theUserAddsTheProductsToTheCart() {
        Assert.assertEquals("2", mainPageServices.numberOfItemsInCart());
    }

    @When("the user clicks on the cart")
    public void theUserClicksOnTheCart() {
        mainPageServices.goToCart();
    }

    @Then("the user navigates to the cart page with all the items in it")
    public void theUserNavigatesToTheCartPageWithAllTheItemsInIt() {
        cartPageServices.getCartPage();
        List<String> actualCartItems = cartPageServices.getCartItems();
        List<String> expectedCartItems = new ArrayList<String>();
        expectedCartItems.add("Sauce Labs Fleece Jacket");
        expectedCartItems.add("Sauce Labs Backpack");
        Assert.assertEquals(expectedCartItems, actualCartItems);
    }

    @When("the user clicks on the checkout button")
    public void theUserClicksOnTheCheckoutButton() {
        cartPageServices.proceedToCheckout();
    }

    @Then("the user navigates to the checkout page")
    public void theUserNavigatesToTheCheckoutPage() {
        Assert.assertEquals("Checkout: Your Information",checkoutPageServices.getCheckoutPageTitle());
    }

    @When("the user fills all the form data")
    public void theUserFillsAllTheFormData() {
        checkoutPageServices.enterFirstNameInForm("Abdelrahman");
        checkoutPageServices.enterLastNameInForm("Wagdy");
        checkoutPageServices.enterPostCodeInForm("1234");
    }

    @And("the user clicks on the continue button")
    public void theUserClicksOnTheContinueButton() {
        checkoutPageServices.clickTheContinueButton();
    }

    @Then("the user navigates to the overview page")
    public void theUserNavigatesToTheOverviewPage() {
        Assert.assertEquals("Checkout: Overview",checkoutPageServices.getCheckoutPageTitle());
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(expectedUrl, checkoutPageServices.getCheckoutPageUrl());
    }

    @And("the total items amount before taxes is displayed")
    public void theTotalItemsAmountBeforeTaxesIsDisplayed() {
        Assert.assertEquals("Item total: $79.98", checkoutPageServices.getTotalAmountBeforeTax());
    }

    @When("the user clicks in the finish button")
    public void theUserClicksInTheFinishButton() {
        checkoutPageServices.clickTheFinishButton();
    }

    @Then("the order is placed and a thank you message is displayed")
    public void theOrderIsPlacedAndAThankYouMessageIsDisplayed() {
        Assert.assertEquals("Checkout: Complete!", checkoutPageServices.getCheckoutPageTitle());
        Assert.assertEquals("Thank you for your order!", checkoutPageServices.getThankYouMessage());
        String expectedDispatchMessage = "Your order has been dispatched, " +
                "and will arrive just as fast as the pony can get there!";
        Assert.assertEquals(expectedDispatchMessage, checkoutPageServices.getOrderPlacedMessaged());
    }

    @Given("User logs in successfully")
    public void userLogsInSuccessfully() {
        mainPageServices.validLogin();
    }
}
