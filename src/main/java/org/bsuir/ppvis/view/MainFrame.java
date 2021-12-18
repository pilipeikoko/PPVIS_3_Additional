package org.bsuir.ppvis.view;

import org.bsuir.ppvis.model.Recipe;
import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.observer.MainFrameEvent;
import org.bsuir.ppvis.observer.MainFrameObservable;
import org.bsuir.ppvis.observer.MainFrameObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class MainFrame implements MainFrameObservable {
    private final List<MainFrameObserver> observers;

    private boolean shouldShowNewRecipeChoose;
    private boolean shouldShowContinueCooking;
    private boolean shouldShowCookingProcess;
    private boolean shouldShowListOfReceipts;
    private boolean shouldShowNavigateToAddProduct;
    private boolean shouldShowMatchedReceipts;

    private Recipe listOfRecipesChosenRecipe;
    private List<BaseQuestion> newRecipeQuestions;
    private String productName;
    private int productAmount;

    {
        observers = new ArrayList<>();
    }

    public abstract void showForNewRecipe(List<BaseQuestion> questions);

    public abstract void showForMain();

    public abstract void showForListOfRecipes(List<Recipe> recipes);

    public abstract void showForCookingProcess(Recipe recipe);

    public abstract void showForAddProduct();

    public void setNewRecipeQuestions(List<BaseQuestion> newRecipeQuestions) {
        this.newRecipeQuestions = newRecipeQuestions;
        notifyObservers("newRecipeQuestions");
    }

    public void setListOfRecipesChosenRecipe(Recipe listOfRecipesChosenRecipe) {
        this.listOfRecipesChosenRecipe = listOfRecipesChosenRecipe;
        notifyObservers("listOfRecipesChosenRecipe");
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
        notifyObservers("productAmount");
    }

    public void setProductName(String productName) {
        this.productName = productName;
        notifyObservers("productName");
    }

    public void setShouldShowNewRecipeChoose(boolean shouldShowNewRecipeChoose) {
        this.shouldShowNewRecipeChoose = shouldShowNewRecipeChoose;
        notifyObservers("shouldShowNewRecipeChoose");
    }

    public void setShouldShowContinueCooking(boolean shouldShowContinueCooking) {
        this.shouldShowContinueCooking = shouldShowContinueCooking;
        notifyObservers("shouldShowContinueCooking");
    }

    public void setShouldShowCookingProcess(boolean shouldShowCookingProcess) {
        this.shouldShowCookingProcess = shouldShowCookingProcess;
        notifyObservers("shouldShowCookingProcess");
    }

    public void setShouldShowListOfReceipts(boolean shouldShowListOfReceipts) {
        this.shouldShowListOfReceipts = shouldShowListOfReceipts;
        notifyObservers("shouldShowListOfReceipts");
    }

    public void setShouldShowNavigateToAddProduct(boolean shouldShowNavigateToAddProduct) {
        this.shouldShowNavigateToAddProduct = shouldShowNavigateToAddProduct;
        notifyObservers("shouldShowNavigateToAddProduct");
    }

    public void setShouldShowMatchedReceipts(boolean shouldShowMatchedReceipts) {
        this.shouldShowMatchedReceipts = shouldShowMatchedReceipts;
        notifyObservers("shouldShowMatchedReceipts");
    }

    public Recipe getListOfRecipesChosenRecipe() {
        return listOfRecipesChosenRecipe;
    }

    public List<BaseQuestion> getNewRecipeQuestions() {
        return newRecipeQuestions;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductAmount() {
        return productAmount;
    }


    @Override
    public void attach(MainFrameObserver mainObserver) {
        if (mainObserver != null) {
            this.observers.add(mainObserver);
        }
    }

    @Override
    public void detach(MainFrameObserver mainObserver) {
        if (mainObserver != null) {
            this.observers.remove(mainObserver);
        }
    }

    @Override
    public void notifyObservers(String property) {
        MainFrameEvent event = new MainFrameEvent(this, property);
        for (MainFrameObserver observer : observers) {
            try {
                observer.parameterChanged(event);
            } catch (Exception e) {
                //TODO: to be logged
            }
        }
    }
}
