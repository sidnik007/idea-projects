package com.nelkinda.recruitment.supermarket;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupermarketStepdefs {
    private final ProductService productService = new MockProductService();

    private ShoppingCart shoppingCart;

    @Given("^an empty shopping cart$")
    public void anEmptyShoppingCart() throws Throwable {
        shoppingCart = new ShoppingCart();
    }

    @And("^a product \"([^\"]*)\" with unit price (\\d+)$")
    public void aProductWithUnitPrice(String productName, int unitPrice) throws Throwable {
        productService.createProduct(productName, unitPrice);
    }

    @When("^the user adds (\\d+) \"([^\"]*)\" in the shopping cart$")
    public void theUserAddsInTheShoppingCart(int count, String productName) throws Throwable {
        shoppingCart.add(productService.getByProductName(productName), count);
    }

    @Then("^the shopping cart MUST contain (\\d+) \"([^\"]*)\" of unit price (\\d+)$")
    public void theShoppingCartMustContainOfUnitPrice(int expectedCount, String productName, int expectedUnitPrice) throws Throwable {
        assertEquals(expectedCount, shoppingCart.getCount(productService.getByProductName(productName)));
        assertEquals(expectedUnitPrice, productService.getByProductName(productName).getUnitPrice());
    }

    @And("^the shopping cart's total price MUST be (\\d+)$")
    public void theShoppingCartTotalPriceMustBe(int expectedTotal) throws Throwable {
        assertEquals(expectedTotal, shoppingCart.getTotal());
    }
}
