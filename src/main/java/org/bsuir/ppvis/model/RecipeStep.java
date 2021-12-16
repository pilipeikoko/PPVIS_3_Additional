package org.bsuir.ppvis.model;

public class RecipeStep {
    private Product product;
    private int amount;
    private String stepDescription;

    public RecipeStep(Product product, int amount, String stepDescription) {
        this.product = product;
        this.amount = amount;
        this.stepDescription = stepDescription;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Product: ");
        stringBuilder.append(product.getName());
        stringBuilder.append("\n Amount: ");
        stringBuilder.append(amount);
        stringBuilder.append("\n Description: ");
        stringBuilder.append(stepDescription);
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}