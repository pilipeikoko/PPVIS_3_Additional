package org.bsuir.ppvis.model;

import java.util.List;

public class Alergy {
    private String name;
    private List<Product> products;

    public Alergy(String name,List<Product> products){
        this.name = name;
        this.products = products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }
}