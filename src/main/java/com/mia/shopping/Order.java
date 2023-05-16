package com.mia.shopping;

public class Order {
    private int quantity;
    private Product product;


    public Order(){}
    public Order(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int updateProductQuantity(){
        int quantityAfterOrder = 0;
        int currentQuantityLeft = this.product.getQuantity();
        return quantityAfterOrder = currentQuantityLeft - 1;
    }
}
