package org.bsuir.ppvis.view.impl;

import java.util.Scanner;

public class ConsoleMainFrameExtended extends ConsoleMainFrame {
    private boolean shouldShowNavigateToAddCutlery;
    private boolean shouldAddCutlery;

    private String cutleryName;
    private int cutleryAmount;


    public void setShouldShowNavigateToAddCutlery(boolean shouldShowNavigateToAddCutlery) {
        this.shouldShowNavigateToAddCutlery = shouldShowNavigateToAddCutlery;
        notifyObservers("shouldShowNavigateToAddCutlery");
    }


    public void setShouldAddCutlery(boolean shouldAddCutlery) {
        this.shouldAddCutlery = shouldAddCutlery;
        notifyObservers("shouldAddCutlery");
    }


    public void setCutleryName(String cutleryName) {
        this.cutleryName = cutleryName;
        notifyObservers("cutleryName");
    }


    public void setCutleryAmount(int cutleryAmount) {
        this.cutleryAmount = cutleryAmount;
        notifyObservers("cutleryAmount");
    }

    public int getCutleryAmount() {
        return cutleryAmount;
    }

    public String getCutleryName() {
        return cutleryName;
    }

    public boolean isShouldAddCutlery() {
        return shouldAddCutlery;
    }

    public boolean isShouldShowNavigateToAddCutlery() {
        return shouldShowNavigateToAddCutlery;
    }

    public void showForAddCutlery() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cutlery name : ");
        setCutleryName(scanner.nextLine());

        System.out.println("Cutlery amount : ");
        setCutleryAmount(scanner.nextInt());

        setShouldAddCutlery(true);
    }

    @Override
    public void showForMain() {
        System.out.println("1. New recipe");
        System.out.println("2. Continue current");
        System.out.println("3. Look all recipes");
        System.out.println("4. Add product");
        System.out.println("5. Add cutlery");
        Scanner scanner = new Scanner(System.in);

        int chosenNumber = scanner.nextInt();

        handleMainAction(chosenNumber);
    }

    @Override
    protected void handleMainAction(int chosenNumber) {
        super.handleMainAction(chosenNumber);
        if (chosenNumber == 5) {
            setShouldShowNavigateToAddCutlery(true);
        }
    }

}
