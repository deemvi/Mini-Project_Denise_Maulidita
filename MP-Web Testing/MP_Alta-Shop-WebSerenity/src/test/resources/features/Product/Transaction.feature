Feature: Transactions
  As a user
  I want to see transactions
  So that I can track my orders


  Background:
    Given I am on the homepage
    When I click beli button in product
    And I click cart icon
    And I redirected to the transaction page

  Scenario: As a user I can view transaction product
    Then I can track my order

  Scenario: As a user I notice there is no payment button in the transaction
    Then I noticed that I couldn't continue the purchasing process
  