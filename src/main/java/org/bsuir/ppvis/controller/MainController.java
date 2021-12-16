package org.bsuir.ppvis.controller;

import org.bsuir.ppvis.controller.command.Command;
import org.bsuir.ppvis.factory.impl.CommandFactoryImpl;
import org.bsuir.ppvis.model.UserContext;
import org.bsuir.ppvis.observer.MainFrameEvent;
import org.bsuir.ppvis.observer.MainFrameObserver;
import org.bsuir.ppvis.view.MainFrame;
import org.bsuir.ppvis.view.impl.ConsoleMainFrame;

import java.util.Map;

public class MainController implements MainFrameObserver {
    private final Map<String, Command> commands;
    private final MainFrame mainFrame;
    private final UserContext userContext;

    {
        mainFrame = new ConsoleMainFrame();
        mainFrame.attach(this);
        userContext = new UserContext();

        CommandFactoryImpl factory = new CommandFactoryImpl();
        commands = factory.create();
    }

    public MainController() {
        navigateToMain();
    }

    @Override
    public void parameterChanged(MainFrameEvent event) {
        switch (event.getProperty()) {
            case "mainActionType": {
                handleMainAction();
                break;
            }
            case "newRecipeQuestions": {
                handleNewRecipeQuestions();
                break;
            }
            case "listOfRecipesChosenRecipe": {
                handleChosenRecipe();
                break;
            } case "productAmount":{
                handleAddProduct();
            }
        }
    }

    private void handleAddProduct() {
        commands.get("AddProduct").execute(mainFrame, userContext);
    }

    private void handleChosenRecipe() {
        commands.get("NavigateToCookingProcess").execute(mainFrame, userContext);
    }

    private void navigateToMain() {
        commands.get("NavigateToMain").execute(mainFrame, userContext);
    }


    private void handleNewRecipeQuestions() {
        if (mainFrame.getNewRecipeQuestions().size() == 2) {
            navigateToListOfMatchedReceipts();
        }
    }

    private void navigateToListOfMatchedReceipts() {
        commands.get("NavigateToListOfMatchedRecipes").execute(mainFrame, userContext);
    }

    private void handleMainAction() {
        //TODO: get rid of 1 and 2
        if (mainFrame.getMainActionType() == 1) {
            navigateToNewRecipe();
        } else if (mainFrame.getMainActionType() == 2) {
            navigateToCookingProcess();
        } else if (mainFrame.getMainActionType() == 3) {
            navigateToListOfReceipts();
        } else if (mainFrame.getMainActionType() == 4) {
            navigateToAddProduct();
        }
    }

    private void navigateToAddProduct() {
        commands.get("NavigateToAddProduct").execute(mainFrame, userContext);
    }

    private void navigateToListOfReceipts() {
        commands.get("NavigateToListOfRecipes").execute(mainFrame, userContext);
    }

    private void navigateToCookingProcess() {
        commands.get("NavigateToCookingProcess").execute(mainFrame, userContext);
    }

    private void navigateToNewRecipe() {
        commands.get("NavigateToNewRecipe").execute(mainFrame, userContext);
    }


}
