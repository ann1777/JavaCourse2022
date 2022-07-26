Feature: Contact search

  Scenario: search contacts present
    When I opened searchContact page
    And type into search field "Sara"
    And click on the search button
    Then the search result should be completed as 'Sara Alston'

    When I have 'Sara Alston' as a search result on the aesrchContact page
    And navigate to the searchResultDetails page
    Then I see "Sara Alston" in the field 'Contact Name'