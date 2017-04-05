Feature: To check television page is working as expected

  @search_television
  Scenario Outline: check the search functionality
    Given I am on television page
    When I select screen size "<Screen size>"
    Then I check the correct "<Screen size>" result are displayed

    Examples:
      | Screen size |
      | 17-22       |
      | 24-32       |
      | 39-46       |
      | 47-50       |
      | 51-55       |
      | 60-65       |
