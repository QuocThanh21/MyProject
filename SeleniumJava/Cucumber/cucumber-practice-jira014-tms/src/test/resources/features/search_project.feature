@search_project
Feature: Search project function
  As admin I would like to search projects in the application
  Background: the user is logged into the system with admin account
    Given the user is logged into the system with valid account
      |username |password|
      |Admin2   |qp$#tGu^|

  @search_project_successfully_with_Name_Location_Type
  Scenario: Search project with any criteria successfully
    And the user navigate the Search Project page
    When the user applies some search criteria
      |Project Name      |Location|Project Type|
      |Thanh Project Name|USA     |ODC         |
    And the user clicks on Search button
    Then all projects matched with input criteria will be displayed

