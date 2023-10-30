Feature: Register
    As a user
    I want to register
    So that I can make purchases and track my orders

    Background:
        Given I am on the register page

  Scenario: As a user I can register with valid inputs
      When I input nama lengkap
      And I input email
      And I input password for register
      And I input register button
      Then I redirected to login page

    Scenario: As a user notices none exist error message when not filling in all inputs
        When I not input nama lengkap
        And I not input email
        And I not input password
        And I click register
        Then registration failed and there is no error message