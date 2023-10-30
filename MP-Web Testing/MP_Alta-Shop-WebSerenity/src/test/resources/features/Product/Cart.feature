Feature: Cart
    As a user
    I want to add and manage products in my cart
    So that I can review and purchase them later

    Background:
        Given I am on the homepage

  Scenario: As a user I can add product to the cart
      When I click beli button in product
      And I click cart icon
      Then I redirected to cart page

    Scenario: As a user I can not see cart list if no items have been added
      When I click cart icon with empty list
      Then I redirected to empty cart page with message error "Order is empty!"