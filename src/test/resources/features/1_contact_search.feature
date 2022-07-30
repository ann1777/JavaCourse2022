Feature: Contact search

  Scenario Outline: Search for contacts present by firsName
    Given Search page is displayed
    When I search for <firstName>
    And I click on the search button
    Then the search result should be completed as this user <fullName>
    Examples:
      | firstName   | fullName      |
      | "Sara"      | "Sara Alston" |

  Scenario Outline: Search result cuntact opens in searchResultDetails
    Given Search page is displayed
    When I search for <firstName>
    And I navigate to the searchResultDetails page
    Then I see user <fullName> in the ContactName field
    Examples:
      | firstName | fullName      |
      | "Sara"    | "Sara Alston" |

  Scenario Outline: search contact is possible by LastName
    Given Search page is displayed
    When I search for <lastName>
    And I click on the search button
    Then the search result should be completed as this user <fullName>
    Examples:
      | lastName | fullName      |
      | "Alston" | "Sara Alston" |

  Scenario Outline: search contact that is absent in contacts list
    Given Search page is displayed
    When I search for <someText>
    And I click on the search button
    Then the search result should be completed with an <expectedResultNotification> under screen
  Examples:
    | someText            | expectedResultNotification                            |
    | "AbsentUser"        | "No contacts found with \"AbsentUser\" in the name"   |