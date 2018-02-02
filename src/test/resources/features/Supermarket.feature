Feature: Shopping Cart

  Scenario: Adding a product to the shopping cart
    Given an empty shopping cart
      POST /cart
    And a product "Dove Soap" with unit price 30
      POST /product
    When the user adds 5 "Dove Soap" in the shopping cart
      PUT /cart/<cardId>/<productId>?count=5
    Then the shopping cart MUST contain 5 "Dove Soap" of unit price 30
      GET /cart/<cardId>
    And the shopping cart's total price MUST be 150
      GET /cart/<cartId>

  Scenario: Add multiple products to the shopping cart
    Given an empty shopping cart
    And a product "Dove Soap" with unit price 30
    And a product "Axe Deo" with unit price 100
    When the user adds 3 "Dove Soap" in the shopping cart
    And the user adds 2 "Axe Deo" in the shopping cart
    Then the shopping cart MUST contain 3 "Dove Soap" of unit price 30
    And the shopping cart MUST contain 2 "Axe Deo" of unit price 100
    And the shopping cart's total price MUST be 290
