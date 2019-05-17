Feature: first test case using selenium

  Background: I have a valid browser
    Given I have a browser installed on the machine


  Scenario Outline: trying to navigate to google
    Given The <browser> is opened
    When I navigate to the URL www.google.com
    Then The google page should be displayed correctly
    Examples:
      | browser   |
      | CHROME    |
      | IEXPLORER |
      | FIREFOX   |

  Scenario: validate  that the search button works
    Given I navigate to the initial page www.google.com
    When I put the Url amazon.com in the search field
    And I press the button Google Search
    Then The search results of amazon.com should be displayed in the results list

  Scenario: Validate button "About Google" works
    Given I navigate to the initial page www.google.com
    When I press the "About Google" hyperlink
    Then The google help page should be displayed