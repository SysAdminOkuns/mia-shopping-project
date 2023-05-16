package com.mia.shopping;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int addProduct(Product myProduct){
        products.add(myProduct);
        return this.products.size();
    }

    public Product removeProduct(Product product){
        int index = this.products.indexOf(product);
        return this.products.remove(index);
    }

    public int getProductSize(){
        return this.products.size();
    }
}
