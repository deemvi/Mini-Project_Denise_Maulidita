@CreateNewData
Feature: Create a new product
    As a user
    I want to add a new product
    So that I can make it available for purchase

    Background:
        Given I set API endpoint for creating a new product is available

      @CreateNewDataProduct-Positive
    Scenario: As a user I can create a new product with valid inputs
      When I send a request POST to create a new product with valid inputs
      And I should receive a status code of 200
      Then I should receive the details of the newly created product


    Scenario:As a user I can not create new product without required fields
          When I send a request to create a new product with required fields
          And I should receive a status code of 500
          Then I should receive an error message indicating the missing fields
