package com.nelkinda.recruitment.supermarket;

public class Product {
    private int unitPrice;
    private String productName;

    public Product(String productName, int unitPrice) {
        this.productName = productName;
        this.unitPrice = unitPrice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getProductName() {
        return productName;
    }
}
