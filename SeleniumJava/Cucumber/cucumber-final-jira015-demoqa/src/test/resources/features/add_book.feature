@add_book
Feature: Add book to your collection

  Background:
    Given Book "Git Pocket Guide" is not in your collection

  @add_book_successfully
  Scenario: Add book to your collection successfully
    Given the user logs into application
    And the user is on Book Store page
    When the user selects a book "Git Pocket Guide"
    And the user clicks on Add To Your Collection
    Then an alert "Book added to your collection." is shown
    And book is shown in your profile