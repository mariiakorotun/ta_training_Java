Feature: Login functionality on SauceDemo

  Scenario: Login with empty credentials
    Given I am on the SauceDemo login page
    When I type any credentials in the username and password fields
    And I clear the inputs
    And I click on the login button
    Then I should see "Username is required" message

  Scenario: Login with username only
    Given I am on the SauceDemo login page
    When I type "standard_user" in the username field
    And I leave the password field empty
    And I click on the login button
    Then I should see "Password is required" message

  Scenario: Successful login
    Given I am on the SauceDemo login page
    When I type "standard_user" in the username field
    And I type "secret_sauce" in the password field
    And I click on the login button
    Then I should see the dashboard page with title "Swag Labs"