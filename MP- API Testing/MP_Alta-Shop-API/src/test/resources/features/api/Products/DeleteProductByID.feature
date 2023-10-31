Feature: Delete a product
    As a user
    I want to delete a product by its ID
    So that I can remove it from the system

    Scenario: As a user I can delete a product by valid ID
        Given I set API endpoint for delete product By valid ID
        When I send a request to delete the product with the valid ID
        And I should receive a status code of 200
        Then I received a message indicating that the product was successfully removed

    Scenario: As a user I can not delete a product with invalid or non-existent ID
        Given I set API endpoint for delete product By invalid ID
        When I send a request to delete the product with the invalid ID
        And I should receive a status code of 404
        Then I should receive an error message indicating that the product was not found