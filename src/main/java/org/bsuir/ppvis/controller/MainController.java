package org.bsuir.ppvis.controller;

import org.bsuir.ppvis.controller.command.Command;
import org.bsuir.ppvis.factory.CommandFactory;
import org.bsuir.ppvis.model.UserContext;
import org.bsuir.ppvis.observer.MainFrameEvent;
import org.bsuir.ppvis.observer.MainFrameObserver;
import org.bsuir.ppvis.service.RecipeService;
import org.bsuir.ppvis.view.MainFrame;

import java.util.Map;

public class MainController implements MainFrameObserver {
    private final Map<String, Command> commands;
    private final MainFrame mainFrame;
    private final UserContext userContext;

    public MainController(MainFrame mainFrame, UserContext context, CommandFactory commandFactory) {
        this.mainFrame = mainFrame;
        mainFrame.attach(this);

        this.userContext = context;
        this.commands = commandFactory.create();

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
        executeCommand(commands.get("NavigateToContinueCooking"));
    }

    private void addProduct() {
        executeCommand(commands.get("AddProduct"));
    }

    private void navigateToMain() {
        executeCommand(commands.get("NavigateToMain"));
    }

    private void navigateToListOfMatchedReceipts() {
        executeCommand(commands.get("NavigateToListOfMatchedRecipes"));
    }

    private void navigateToAddProduct() {
        executeCommand(commands.get("NavigateToAddProduct"));
    }

    private void navigateToListOfReceipts() {
        executeCommand(commands.get("NavigateToListOfRecipes"));
    }

    private void navigateToCookingProcess() {
        executeCommand(commands.get("NavigateToCookingProcess"));
    }

    private void navigateToNewRecipe() {
        executeCommand(commands.get("NavigateToNewRecipe"));
    }

    private void executeCommand(Command command) {
        command.execute(mainFrame, userContext);
    }
}
