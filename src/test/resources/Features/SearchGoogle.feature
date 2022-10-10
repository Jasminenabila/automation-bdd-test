Feature: Search Google
  Scenario: feature search on google successfully data found
    Given User Open browser
    And Open website Google
    And Located on google website
    When User search "Jasmine Nabila Novel"
    Then Showing result related with "Jasmine Nabila Novel"
