package org.bsuir.ppvis.repository.impl;

import org.bsuir.ppvis.model.Product;
import org.bsuir.ppvis.repository.ProductRepository;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> allProducts;

    private ProductRepositoryImpl(){

    }

    private static class Holder
    {
        private static final ProductRepositoryImpl INSTANCE = new ProductRepositoryImpl();
    }

    public static ProductRepositoryImpl getInstance()
    {
        return ProductRepositoryImpl.Holder.INSTANCE;
    }
}
