Feature: BestBuy Search Functionality

  Scenario: Search Iphone 13
    Given Best-buy URL loads successfully
    When User enters "Iphone 13" on search bar and click the search icon.
    Then Searched product description "Apple - Pre-Owned iPhone 13 Pro 5G 128GB (Unlocked) - Graphite" model "A2483-GRY" price "$879.99" should be validated


  Scenario: Search Iphone 13 and add to the cart
    Given Best-buy URL loads successfully
    When User enters "Iphone 13" on search bar and click the search icon.
    And Add to the cart the specific Iphone mode "Apple - Pre-Owned iPhone 13 Pro 5G 128GB (Unlocked) - Graphite"
    And Click on go to the cart
    Then Verify "Order Summary" and "Checkout" displayed

  Scenario: validate a cart page
    Given Best-buy URL loads successfully
    When User enters "Iphone 12" on search bar and click the search icon.
    And Add to the cart the specific Iphone mode "Apple - iPhone 12 5G 64GB (Unlocked) - Black"
    And Click on go to the cart
    Then Verify "Order Summary" and "Checkout" displayed

