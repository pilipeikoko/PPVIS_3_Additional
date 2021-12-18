package org.bsuir.ppvis.model;

import java.util.HashMap;
import java.util.Map;

public class User {
    private final Map<Product, Integer> products;

    {
        products = new HashMap<>();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product, int amount) {
        if (products.containsKey(product)) {
            int value = products.get(product);
            products.replace(product, value + amount);
        } else {
            products.put(product, amount);
        }
    }
}
