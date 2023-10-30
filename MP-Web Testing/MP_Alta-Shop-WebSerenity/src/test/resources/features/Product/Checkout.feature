Feature:  Checkout
  As a user
  I want to checkout my selected products
  So that I can make a purchase and receive the ordered products

  Scenario: As a user I can add products to the cart and proceeds to checkout
    Given I am on the homepage
    When I click beli button in product
    And I click cart icon
    And I see list of product in cart page
    And I click bayar button
    Then I redirected to the transaction page


  Scenario: As a user I can not checkout without adding any products to the cart
    Given I am on the homepage
    When I click cart icon with empty list
    And I tried to proceed with checkout without any products in the cart
    Then The system cannot process the checkout with error message "Order is empty!"