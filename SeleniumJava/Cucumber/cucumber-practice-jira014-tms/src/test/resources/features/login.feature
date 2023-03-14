@login
Feature: Login function
  As valid user I would like to log into the application

  @login_successfully_with_valid_account
  Scenario: Login with valid account successfully
    Given the user visits the TMS website
    When the user inputs an account
      |username |password|
      |Admin2   |qp$#tGu^|
    And the user clicks on Login button
    Then the user is logged into the system successfully

  @login_unsuccessfully_with_empty_username
  Scenario: Login with invalid account
    Given the user visits the TMS website
    When the user inputs an account
      |username |password|
      |         |qp$#tGu^|
    And the user clicks on Login button
    Then the error message "This is a required field." will be displayed below username field

  @login_unsuccessfully_with_empty_password
  Scenario: Login with invalid account
    Given the user visits the TMS website
    When the user inputs an account
      |username |password|
      |Admin2   |        |
    And the user clicks on Login button
    Then the error message "This is a required field." will be displayed below password field

  @login_unsuccessfully_with_empty_username_and_password
  Scenario: Login with invalid account
    Given the user visits the TMS website
    When the user inputs an account
      |username |password|
      |         |        |
    And the user clicks on Login button
    Then the error message "This is a required field." will be displayed below username field
    And the error message "This is a required field." will be displayed below password field

  @login_unsuccessfully_with_incorrect_account
  Scenario: Login with invalid account
    Given the user visits the TMS website
    When the user inputs an account
      |username |password|
      |Admin1   |qp$#tGu3|
    And the user clicks on Login button
    Then the error message "The Username or Password you entered is incorrect" will be displayed
