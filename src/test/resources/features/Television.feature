@regression
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
    Then I check the correct "<Screen type>" result are displayed
    Examples:
      | Screen type |
      | OLED        |
      | Plasma      |
      | LED         |
      | Curved      |

  @sort_by
  Scenario Outline: check the search functionality by sort
    Given I am on television page
    When I search television by "<Sort by>"
    Then I check the correct "<Sort by>" result
    Examples:
      | Sort by                   |
      | Price (low to high)       |
      | Price (high to low)       |
      | Screen size (high to low) |
      | Most-recently launched    |

  @AddToCompare
  Scenario: check the comparision of television
    Given I am on television page
    When I add product to compare
    Then I check the comparision

  @Television_page_tabs
  Scenario: check the comparision of television
    Given I am on television page
    Then I check All tabs are displayed
