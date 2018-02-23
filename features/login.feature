Feature: Login to OrangeHRM

  Scenario: Valid user login to OrangeHRM
    Given I have navigated to the login page
    And I have typed username as 'admin'
    And I have typed password as 'admin'
    And Clicked login button
    Then I should be able to see an error message


  Scenario: User login with blank user name
    Given I have navigated to the login page
    And I have typed username as ""
    And I have typed password as "admin"
    And Clicked login button
    Then I should be able to see an error message


  Scenario: User login with invalid input data
    Given I have navigated to the login page
    And I type username and password
      | username | password |
      | admin    |          |
      |          | admin    |
    And Clicked login button
    Then I should be able to see an error in login page
      | errorMessage             |
      | Username cannot be empty |
      | Password cannot be empty |


  Scenario Outline: Use login with different input data
    Given I have navigated to the login page
    And I have typed username as <username>
    And I have typed password as <password>
    And Clicked login button
    Then I should be able to see an error message <expectedError>
    Examples:
      | username | password | expectedError            |
      |          | admin    | Username cannot be empty |
      | admin    |          | Password cannot be empty |
      | admin    | test123  | Invalid credentials      |

