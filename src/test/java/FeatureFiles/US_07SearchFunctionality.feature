Feature: Product Search and Ordering

  Scenario Outline: User searches for a product using SKU and places an order
    Given the user logs into the Magento site
    When the user enters "<SKU>" in the search bar
    Then the search results should display the product "<ProductName>"
    When the user follows the link "Home > Men > Tops > Jackets"
    And clicks on the product "<ProductName>"
    Then the product page should show SKU number "<SKU>"
   # When the user decides to place an order for the product

    Examples:
      | ProductName       | SKU   |
      | Lando Gym Jacket  | MJ08  |