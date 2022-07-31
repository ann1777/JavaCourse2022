Feature: Contact search

  Scenario Outline: Search for contacts present by firsName
    Given Search page is displayed
    When I search for <firstName>
    Then the search result should be completed as this user <fullName>
    Examples:
      | firstName  | fullName          |
      | "Sara"     | "Sara Alston"     |
      | "Jennifer" | "Jennifer Krantz" |
      | "Lynn"     | "Lynn Chandler"   |


  Scenario Outline: Search for contacts present by lastName
    Given Search page is displayed
    When I search for <lastName>
    Then the search result should be completed as this user <fullName>
    Then I clear searchField
    Examples:
      | lastName   | fullName          |
      | "Alston"   | "Sara Alston"     |
      | "Jennifer" | "Jennifer Krantz" |
      | "Lynn"     | "Lynn Chandler"   |

  Scenario Outline: Contact details page is opened from search
    Given Search page is displayed
    When I search for <firstName>
    Then the search result should be completed as this user <fullName>
    When I click on contact in search result
    Then contact page is opened
    Then I see user <fullName> in the ContactName field
    Then I see contact phone <contactPhone> is correct
    Examples:
      | firstName  | fullName          | contactPhone      |
      | "Sara"     | "Sara Alston"     | "+1(343)-4779854" |
      | "Jennifer" | "Jennifer Krantz" | "+1(656)-6779916" |
      | "Lynn"     | "Lynn Chandler"   | "+1(232)-8335268" |


  Scenario Outline: search contact that is absent in contacts list
    Given Search page is displayed
    When I search for <someText>
    Then the search result should be completed with an <expectedResultNotification> under screen
  Examples:
    | someText     | expectedResultNotification                          |
    | "AbsentUser" | "No contacts found with \"AbsentUser\" in the name" |
    | "Test"       | "No contacts found with \"Test\" in the name"       |
    | "Lin"        | "No contacts found with \"Lin\" in the name"        |
    | "***"        | "No contacts found with \"***\" in the name"        |