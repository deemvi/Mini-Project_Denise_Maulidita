# new feature
# Tags: optional

Feature: Get Order by ID
  As a user
  I want to be able to retrieve an order by ID via API in the product store
  So that I can view the specific details of a particular order

  Scenario: As a user I can get order by valid ID
    Given I set API endpoint for get a order by ID
    When I send a request to get the order with the valid ID
    Then I should receive a status code of 200
    And I should receive the details of the order associated with the provided ID

  Scenario: As a user I can not get order with invalid or non-existent ID
    Given I set API endpoint for get a order with invalid ID
    When I send a request GET to get order by id
    Then I should receive a status code of 404
    And I should receive an error message indicating that the product was not found