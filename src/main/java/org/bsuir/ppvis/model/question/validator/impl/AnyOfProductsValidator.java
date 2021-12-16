package org.bsuir.ppvis.model.question.validator.impl;

import org.bsuir.ppvis.model.Product;
import org.bsuir.ppvis.model.question.OneAnswerProvider;
import org.bsuir.ppvis.model.question.validator.MatchValidator;

import java.util.List;

public class AnyOfProductsValidator implements MatchValidator {
    private final List<Product> products;

    public AnyOfProductsValidator(List<Product> products) {
        this.products = products;

    }

    @Override
    public boolean validate(OneAnswerProvider provider) {
        return products.stream().anyMatch(x -> x.getName().equals(provider.getAnswer()));
    }
}
