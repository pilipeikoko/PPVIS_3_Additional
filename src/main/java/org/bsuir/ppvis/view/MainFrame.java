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

    private int mainActionType;
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

    public void setMainActionType(int mainActionType) {
        this.mainActionType = mainActionType;
        notifyObservers("mainActionType");
    }

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

    public Recipe getListOfRecipesChosenRecipe() {
        return listOfRecipesChosenRecipe;
    }

    public int getMainActionType() {
        return mainActionType;
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
