@create_project
Feature: Create project function
  As admin I would like to create a new project
  Background: the user is logged into the system with admin account
    Given the user is logged into the system with valid account
      |username |password|
      |Admin2   |qp$#tGu^|

  @create_project_successfully_with_all_fields
  Scenario: Create Project with all fields successfully
    Given the user navigate to Create Project page
    When the user fills in all project information
    And the user clicks Create button
    Then the successful message "Add project sucessfully" will be displayed
    And all information of the project is shown correctly