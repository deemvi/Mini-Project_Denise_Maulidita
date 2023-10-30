Feature:  Product Detail
  As a user
  I want to view detailed information about a product
  So that I can make informed decisions before making a purchase

  Scenario: As a user I can view all details of a product
    Given I am on the homepage
    When I click detail button in product
    Then I redirected to detail page

  Scenario: As a user I can view all the details of a product without any stock information
    Given I am on the homepage
    When I click detail button in product
    Then I redirected to detail page
    And I noticed there is no stock information in the product details

