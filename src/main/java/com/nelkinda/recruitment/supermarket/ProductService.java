package com.nelkinda.recruitment.supermarket;

public interface ProductService {
    void createProduct(String productName, int unitPrice);

    Product getByProductName(String productName);
}
