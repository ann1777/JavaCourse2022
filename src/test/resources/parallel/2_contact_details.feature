Feature: Contact details

  Scenario Outline: A proper contact name shown on the Contact Detail page
    Given Search page is displayed
    When I search for <firstName>
    And  I click on contact in search result
    Then I see contact <fullName> on the Contact Detail page
    Examples:
      | firstName  | fullName          |
      | "Sara"     | "Sara Alston"     |
      | "Jennifer" | "Jennifer Krantz" |
      | "Lynn"     | "Lynn Chandler"   |

  Scenario Outline: Contact has a proper phone number
    Given Search page is displayed
    When I search for <firstName>
    And  I click on contact in search result
    Then I see <contactPhone> is correct
    Examples:
      | firstName  | contactPhone      |
      | "Sara"     | "+1(343)-4779854" |
      | "Jennifer" | "+1(656)-6779916" |
      | "Lynn"     | "+1(232)-8335268" |