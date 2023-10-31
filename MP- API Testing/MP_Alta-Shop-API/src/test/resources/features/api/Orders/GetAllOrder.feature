
Feature: Get All Orders
  As a user
  I want to be able to get all orders
  So that I can manage and track all orders effectively

  Scenario: As a User I can get all order successfully
    Given I set API endpoint for get all order
    When I send GET request to the endpoint to get all order
    Then the response status code should be 200
    And I receive valid data for get all order

  Scenario: As a user I can not get order with invalid parameters
    Given I set invalid API endpoint for get all order with invalid parameters
    When I send GET request for get all order
    Then the response status code equal 404
    And I receive error message should indicate page not found