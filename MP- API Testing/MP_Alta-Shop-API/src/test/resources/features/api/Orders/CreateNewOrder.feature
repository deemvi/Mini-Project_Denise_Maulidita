@CreateNewOrder
Feature: Creating New Orders
  As a user
  I want to create new orders on the web product store
  So that I can purchase products and manage my transactions effectively

  Background:
    Given I set API for create new orders

  Scenario: As a user I can add products to the cart and proceeds to create a new order
    When I send request for create new order
    Then I should receive a status code of 200
    And I receive valid data for create new order

  Scenario: As a user I can not create new order when not fill all input
    When I send request with required input
    Then I receive status code 400
    And I should receive an error message indicating the missing fields