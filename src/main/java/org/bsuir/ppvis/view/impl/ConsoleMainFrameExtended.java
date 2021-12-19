package org.bsuir.ppvis.view.impl;

import org.bsuir.ppvis.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMainFrameExtended extends ConsoleMainFrame{
    private boolean shouldShowNavigateToAddAlergy;
    private boolean shouldAddAlergy;

    private List<Product> alergyProducts;
    private String alergyName;

    {
        alergyProducts = new ArrayList<>();
    }

    public void setShouldShowNavigateToAddAlergy(boolean shouldShowNavigateToAddAlergy) {
        this.shouldShowNavigateToAddAlergy = shouldShowNavigateToAddAlergy;
        notifyObservers("shouldShowNavigateToAddAlergy");
    }

    public void setShouldAddAlergy(boolean shouldAddAlergy) {
        this.shouldAddAlergy = shouldAddAlergy;
        notifyObservers("shouldAddAlergy");
    }

    public List<Product> getAlergyProducts() {
        return alergyProducts;
    }

    public void setAlergyProducts(List<Product> alergyProducts) {
        this.alergyProducts = alergyProducts;
        notifyObservers("alergyProducts");
    }

    public String getAlergyName() {
        return alergyName;
    }

    public void setAlergyName(String alergyName) {
        this.alergyName = alergyName;
        notifyObservers(alergyName);
    }

    public void showForAddAlergy() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Alergy name : ");
        setAlergyName(scanner.nextLine());

        List<Product> products = new ArrayList<>();

        System.out.println("Products, finish with 0");

        String product = scanner.nextLine();
        while (!product.equals("0")){
            products.add(new Product(product));
            product = scanner.nextLine();
        }
        setAlergyProducts(products);

        setShouldAddAlergy(true);
    }

    @Override
    public void showForMain() {
        System.out.println("1. New recipe");
        System.out.println("2. Continue current");
        System.out.println("3. Look all recipes");
        System.out.println("4. Add product");
        System.out.println("5. Add alergy");
        Scanner scanner = new Scanner(System.in);

        int chosenNumber = scanner.nextInt();

        handleMainAction(chosenNumber);
    }

    @Override
    protected void handleMainAction(int chosenNumber) {
        super.handleMainAction(chosenNumber);
        if (chosenNumber == 5) {
            setShouldShowNavigateToAddAlergy(true);
        }
    }
}