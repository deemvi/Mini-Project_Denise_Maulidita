Feature: Register
  As a user
  I want to register
  So that I can use application features

  Background:
    Given I set API endpoint for register

  @Register
  Scenario: As a user I can register with valid inputs
    When I send request to register
    And I receive status code 200 for register
    Then I receive valid data for register

  Scenario: As a user I can not register with existing credentials
    When I send a request with existing email
    And I should receive a status code of 400
    Then I receive an error message indicating duplicate key value