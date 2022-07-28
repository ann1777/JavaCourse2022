Feature: Contact search

  Scenario: search contacts present
    When I opened searchContact page
    And type into search field <firstName>
    And click on the search button
    Then the search result should be completed as this user <fullName>

    Example:
      | firstName   | fullName      |
      | "Sara"      | "Sara Alston" |

  Scenario: search result cuntact opens in searchResultDetails
    When I have 'Sara Alston' as a search result on the searchContact page
    And navigate to the searchResultDetails page
    Then I see "Sara Alston" in the field 'Contact Name'

    Example:
      | searchResult         | ContactName        |
      | "Sara Alston"        | "Sara Alston"      |

  Scenario: search contact is possible by LastName
    Given I opened searchContact page
    When I type into search field <lastname>
    And click on the search button
    Then the search result should be completed as this user <fullName>

    Example:
      | lastName        | fullName        |
      | "Alston"        | "Sara Alston"   |

  Scenario: search contact that is absent in contacts list
    Given I opened searchContact page
    When I type into search field <someText>
    And click on the search button
    Then the search result should be completed with an <expectedResultNotification> under screen

  Example:
    | someText            | expectedResultNotification                            |
    | "AbsentUser"        | "No contacts found with \"AbsentUser\" in the name"   |