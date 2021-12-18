package org.bsuir.ppvis.factory;

import org.bsuir.ppvis.controller.command.Command;
import org.bsuir.ppvis.service.RecipeService;

//Abstract factory
public interface CommandFactory {
    Command createAddProductCommand();
    Command createNavigateToAddProductCommand();
    Command createNavigateToListOfRecipesCommand(RecipeService recipeService);
    Command createNavigateToCookingProcessCommand();
    Command createNavigateToListOfMatchedRecipesCommand(RecipeService recipeService);
    Command createNavigateToMainCommand();
    Command createNavigateToNewRecipeCommand();
    Command createNavigateToContinueCookingCommand();
}
