package com.nelkinda.recruitment.supermarket;

import java.util.HashMap;

public class MockProductService implements ProductService {
    private HashMap<String, Product> products = new HashMap<>();

    @Override
    public void createProduct(String productName, int unitPrice) {
        Product product = new Product(productName, unitPrice);
        products.put(product.getProductName(), product);
    }

    @Override
    public Product getByProductName(String productName) {
        return products.get(productName);
    }
}
