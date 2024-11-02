Feature: User Adds and Removes Products from Wishlist

  Scenario: User adds a product to the wishlist and removes it
    Given the user logs into the Magento site
    And navigates to the page of a product they like
    When the user clicks the "Add to Wishlist" button
    Then a message indicating that the product has been added to the wishlist is displayed
    Then they see the remove icon
    When the user clicks the "Remove from Wishlist" button
    Then a message indicating that the product has been removed from the wishlist is displayed