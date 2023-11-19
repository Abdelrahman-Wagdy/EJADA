Feature: Test login functionality
  Background:
    Given User navigates to the website

  Scenario: user tries to login with valid credentials
    Given that the user enters a valid user name
    And the user enters a valid password
    Then the user log in successfully

 Scenario Outline: user tries to login with invalid username
   Given that the user enters invalid "<username>"
   And the user enters a valid password
   Then the user fails to login
   Examples:
     | username      |
     | Standard_User |
     | StandardUser  |

  Scenario Outline: user tries to login with invalid password
   Given that the user enters a valid user name
   And the user enters an invalid "<password>"
   Then the user fails to login
   Examples:
     | password     |
     | Secret_Sauce |
     | SECRET_SAUCE |
