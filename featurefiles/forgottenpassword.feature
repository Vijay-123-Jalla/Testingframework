Feature: Forgotten password

  Background: Prerequisite Steps
    Given User is able to open the browser
    And User is able to enter the URL
    And Forgotten link should be displayed
    And Forgotten link should be enabled
    When User clicks on the forgotten link
    Then Input field should be displayed
    And Input field should be enabled
    And Cancel button should be displayed
    And Cancel button should be enabled
    And Reset password button should be displayed
    And Reset password button should be enabled

  Scenario Outline: Resetting the password
    When User enters the "<username>"
    And User clicks on the Reset password button
    Then Mail should be triggered to the user

    Examples: 
      | username |
      | Vijay    |

  Scenario: Remember the password
    When User remembers the details and clicks on cancel button

  Scenario: Not entered any details
    When No details are entered in the username field
    Then Please enter username message should be displayed
