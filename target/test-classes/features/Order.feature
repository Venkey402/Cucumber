@order_functionality
Feature: Ordering in GreenKart

  Background: 
    Given user launches the greenkart application

  @TC_01
  Scenario: 1. Search for a product and add to cart
    When user searches for "Tom" and adds to cart
    Then user checks product with name "Tom" added to the cart

  @TC_02
  Scenario: 2. Checkout products added to the cart
    When user searches for "Tom" and adds to cart
    Then user checks product with name "Tom" added to the cart
    When user checksout the products added to cart
    Then user verifies the product name from order page

  @TC_03
  Scenario: 3. Order the products from checkout page
    When user searches for "Tom" and adds to cart
    Then user checks product with name "Tom" added to the cart
    When user checksout the products added to cart
    Then user verifies the product name from order page
    When user places the order
    And user selects the country "India"
    Then user accepts the agreement
    And user proceeds with the order
    Then user recieves "your order has been placed successfully" message
