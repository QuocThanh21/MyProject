@search_book
Feature: Search book on the Book Store page

  @search_book_successfully
  Scenario Outline: Search book with multiple results successfully
    Given the user is on the Book Store page
    When the user inputs book name <keyword>
    Then all books match with input criteria will be displayed.

  Examples:
    |keyword|
    |Design |
    |design |