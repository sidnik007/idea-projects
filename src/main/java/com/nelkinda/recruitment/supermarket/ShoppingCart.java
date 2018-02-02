package com.nelkinda.recruitment.supermarket;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Product, Integer> cart = new HashMap<>();
    public void add(Product product, int count) {
        cart.put(product, count);
    }

    public int getCount(Product product) {
        return cart.get(product);
    }

    public int getTotal() {
        return cart
                .entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getUnitPrice() * entry.getValue())
                .sum();
    }
}
