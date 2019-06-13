Feature: first test case using selenium


  @qa-automatedTest
  Scenario Outline: trying to navigate to google
    Given The <browser> is opened
    When I navigate to the URL www.google.com
    Then The google page should be displayed correctly
    Examples:
      | browser   |
      | CHROME    |
      | IEXPLORER |
      | FIREFOX   |

  @qa-automatedTest
  Scenario Outline: validate  that the search button works
    Given The <browser> is opened
    Given I navigate to the URL www.google.com
    When I put the Url amazon.com in the search field
    And I press the button Google Search
    Then The search results of amazon.com should be displayed in the results list
    Examples:
      | browser |
      | CHROME  |
   #   | IEXPLORER |
   #   | FIREFOX   |


  @qa-automatedTest
  Scenario Outline: Validate button "About Google" works
    Given The <browser> is opened
    Given I navigate to the URL www.google.com
    When I press the "About Google" hyperlink
    Then The google help page should be displayed
    Examples:
      | browser |
      | CHROME  |
      #| IEXPLORER |
      #| FIREFOX   |

  @qa-automatedTest
  Scenario Outline: Search product in Amazon
    Given The <browser> is opened
    And I navigate to the main Amazon page
    When I press the button To day's Deals hyperlink
    And I press button "Sort by" -Low to High
    Then Products must be shown from lowest to highest value
    Examples:
      | browser |
      | CHROME  |
      #| IEXPLORER |
      #| FIREFOX   |

  @qa-automatedTest
  Scenario Outline: Search product in Fender
    Given The <browser> is opened
    And I navigate to the main Fender page
    When I press button search
    And Enter something to search for "Telecaster", click
    Then Displayed products "Telecaster" new arrivals
    Examples:
      | browser |
      | CHROME  |
      #| IEXPLORER |
      #| FIREFOX   |



