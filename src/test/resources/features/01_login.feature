@login
Feature: Login

  Scenario: User Want to Login : with valid credentials
    Given I am Testing Case : "1"
    And User arrives to Login Page
    And I enter a valid username
    And I click on continue
    And I enter a valid password
    And I click on the login button
    And I choose a location
    Then I verify login


  Scenario: User skips location selection and is directed to the dashboard when 'Remember my location' was enabled in a prior session
    Given I am Testing Case : "2"
    And User arrives to Login Page
    And I enter a valid username
    And I click on continue
    And I enter a valid password
    And I click on the login button
    Then I am navigated to the dashboard page
    And I remove my login location preference


  Scenario: User can logout successfully
    Given I am Testing Case : "3"
    And I login into Application
    And I remove my login location preference
    And I click on my account icon
    And I click on Logout
    Then user is logged out


  Scenario: User cannot login with invalid credentials
    Given I am Testing Case : "4"
    And User arrives to Login Page
    And I enter an invalid username
    And I click on continue
    And I enter a valid password
    And I click on the login button
    Then I get an error message

