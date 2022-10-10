Feature: Orange HRM open source
  Scenario Outline: Login success with data valid
    Given User open url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User input "<username>" and "<password>"
    And User click button login
    Then User should be success login
    Examples:
    |username|password|
    |Admin|admin123|

  Scenario Outline: Login Failed with username null
    Given User open url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User input "<username>" and "<password>"
    And User click button login
    Then User should be failed login
    Examples:
    |username|password|
    |        |admin123|

  Scenario Outline: Login Failed with username and password not found
    Given User open url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User input "<username>" and "<password>"
    And User click button login
    Then User should be failed login because data not registered
    Examples:
    |username|password|
    |jasmine|passwo123|
