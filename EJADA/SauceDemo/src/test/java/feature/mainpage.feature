Feature: Check the items in the main page
  Background:
    Given User logs in successfully

  Scenario: Add the two most expensive products to your cart and full scenario until processing the order
    Given the user chooses the two most expensive products
    And the user adds the products to the cart
    When the user clicks on the cart
    Then the user navigates to the cart page with all the items in it
    When the user clicks on the checkout button
    Then the user navigates to the checkout page
    When the user fills all the form data
    And the user clicks on the continue button
    Then the user navigates to the overview page
    And the total items amount before taxes is displayed
    When the user clicks in the finish button
    Then the order is placed and a thank you message is displayed

    ## Add to sort the most expensive items