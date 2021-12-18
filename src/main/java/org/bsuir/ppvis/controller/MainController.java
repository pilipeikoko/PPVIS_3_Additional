package org.bsuir.ppvis.controller;

import org.bsuir.ppvis.controller.command.Command;
import org.bsuir.ppvis.factory.CommandFactory;
import org.bsuir.ppvis.model.UserContext;
import org.bsuir.ppvis.observer.MainFrameEvent;
import org.bsuir.ppvis.observer.MainFrameObserver;
import org.bsuir.ppvis.service.RecipeService;
import org.bsuir.ppvis.view.MainFrame;

public class MainController implements MainFrameObserver {
    private final CommandFactory commandFactory;
    private final RecipeService recipeService;
    private final MainFrame mainFrame;
    private final UserContext userContext;

    public MainController(MainFrame mainFrame, UserContext context, CommandFactory commandFactory, RecipeService recipeService) {
        this.mainFrame = mainFrame;
        mainFrame.attach(this);

        this.userContext = context;
        this.commandFactory = commandFactory;
        this.recipeService = recipeService;

        navigateToMain();
    }

    @Override
    public void parameterChanged(MainFrameEvent event) {
        switch (event.getProperty()) {
            case "shouldShowNewRecipeChoose": {
                handleNewRecipeChoose();
                break;
            }
            case "shouldShowContinueCooking": {
                handleContinueCooking();
                break;
            }
            case "shouldShowCookingProcess": {
                handleCookingProcess();
                break;
            }
            case "shouldShowListOfReceipts": {
                handleListOfReceipts();
                break;
            }
            case "shouldShowNavigateToAddProduct": {
                handleNavigateToAddProduct();
                break;
            }
            case "shouldShowAddProduct": {
                handleAddProduct();
                break;
            }
            case "shouldShowMatchedReceipts": {
                handleMatchedReceipts();
                break;
            }
            case "shouldShowMain": {
                handleMainAction();
                break;
            }
        }
    }

    private void handleMatchedReceipts() {
        navigateToListOfMatchedReceipts();
    }

    private void handleNavigateToAddProduct() {
        navigateToAddProduct();
    }

    protected void handleListOfReceipts() {
        navigateToListOfReceipts();
    }

    protected void handleCookingProcess() {
        navigateToCookingProcess();
    }

    protected void handleContinueCooking() {
        navigateToContinueCooking();
    }

    protected void handleNewRecipeChoose() {
        navigateToNewRecipe();
    }

    protected void handleMainAction() {
        navigateToMain();
    }

    protected void handleAddProduct() {
        addProduct();
    }

    private void navigateToContinueCooking() {
        executeCommand(commandFactory.createNavigateToContinueCookingCommand());
    }

    private void addProduct() {
        executeCommand(commandFactory.createAddProductCommand());
    }

    private void navigateToMain() {
        executeCommand(commandFactory.createNavigateToMainCommand());
    }

    private void navigateToListOfMatchedReceipts() {
        executeCommand(commandFactory.createNavigateToListOfMatchedRecipesCommand(recipeService));
    }

    private void navigateToAddProduct() {
        executeCommand(commandFactory.createNavigateToAddProductCommand());
    }

    private void navigateToListOfReceipts() {
        executeCommand(commandFactory.createNavigateToListOfRecipesCommand(recipeService));
    }

    private void navigateToCookingProcess() {
        executeCommand(commandFactory.createNavigateToCookingProcessCommand());
    }

    private void navigateToNewRecipe() {
        executeCommand(commandFactory.createNavigateToNewRecipeCommand());
    }

    private void executeCommand(Command command) {
        command.execute(mainFrame, userContext);
    }
}
