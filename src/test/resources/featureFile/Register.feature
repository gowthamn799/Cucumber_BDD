Feature: Register Page
  Scenario: User Registration
    Given I am on the registration page
    When I enter valid registration details
    And I submit the registration form
    Then I should see a confirmation message