@delete_book
Feature: Delete book from your collection

  @delete_book_successfully
  Scenario: Delete book successfully
    Given there is a book named "Git Pocket Guide" in your collection
    And the user logs into the application
    And the user is on the Profile page
    When the user search book "Git Pocket Guide"
    And the user clicks on Delete icon
    And the user clicks on OK button
    And the user clicks on OK button of alert "Book deleted."
    And the book is not shown