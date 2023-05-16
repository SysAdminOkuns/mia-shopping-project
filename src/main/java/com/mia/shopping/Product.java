package com.mia.shopping;

public class Product {

    private String productName;
    private  String description;
    private int quantity;

    public Product() {}

    public Product(String productName, String description, int quantity) {
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
