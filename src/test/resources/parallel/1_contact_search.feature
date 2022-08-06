Feature: Contact search
  Look for the contacts on the Search page

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
    When I clear searchField
    Then the <firstSearchResultName> is displayed under search field
    Examples:
      | lastName   | fullName          | firstSearchResultName |
      | "Alston"   | "Sara Alston"     | "Jenny Cherry"        |
      | "Jennifer" | "Jennifer Krantz" | "Jenny Cherry"        |
      | "Lynn"     | "Lynn Chandler"   | "Jenny Cherry"        |


  Scenario Outline: Contact details page is opened from search
    Given Search page is displayed
    When I search for <firstName>
    Then the search result should be completed as this user <fullName>
    When I click on contact in search result
    Then Contact details page is opened
    When I see contact <fullName> on the Contact Detail page
    Then I see <contactPhone> is correct
    Examples:
      | firstName  | fullName          | contactPhone      |
      | "Sara"     | "Sara Alston"     | "+1(343)-4779854" |
      | "Jennifer" | "Jennifer Krantz" | "+1(656)-6779916" |
      | "Lynn"     | "Lynn Chandler"   | "+1(232)-8335268" |


  Scenario Outline: Search for the absent contacts in contacts list
    Given Search page is displayed
    When I search for <someText>
    Then the search result should be completed with an <expectedResultNotification> in the screen
  Examples:
    | someText        | expectedResultNotification                             |
    | "AbsentContact" | "No contacts found with \"AbsentContact\" in the name" |
    | "Test"          | "No contacts found with \"Test\" in the name"          |
    | "Lin"           | "No contacts found with \"Lin\" in the name"           |
    | "***"           | "No contacts found with \"***\" in the name"           |
