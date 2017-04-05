Feature: To check television page is working as expected

  @search_television_by_size
  Scenario Outline: check the search functionality by size
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

  @search_television_by_type
  Scenario Outline: check the search functionality by type
    Given I am on television page
    When I select screen type "<Screen type>"
    Examples:
      | Screen type |
      | OLED        |
      | Plasma      |
      | LED         |
      | Curved      |