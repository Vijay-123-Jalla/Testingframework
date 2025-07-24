Feature: Login into the OrangeHRM

  Background: Prerequisite Steps
    Given User able to open the browser
    And User able to enter the url
    Given Inputfield has to display
    Given Passwordfield has to display
    Given Submit button has to dispaly

  Scenario Outline: Logging with valid crendentials
    When User able to enter the username "<Username>"
    And User able to enter the password "<Password>"
    And User able to click on button
    Then User able to login succesfully

    Examples: 
      | Username | Password |
      | Admin    | admin123 |

  Scenario Outline: Logging with invalid crendentials
    When User able to enter the username "<Username>"
    And User able to enter the password "<Password>"
    And User able to click on button
    Then User not able to login

    Examples: 
      | Username | Password |
      | Admin1   | admin12  |
