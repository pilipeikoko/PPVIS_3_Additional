package org.bsuir.ppvis.factory.impl;

import org.bsuir.ppvis.controller.command.Command;
import org.bsuir.ppvis.controller.command.impl.*;
import org.bsuir.ppvis.factory.CommandFactory;
import org.bsuir.ppvis.service.RecipeService;

import java.util.HashMap;
import java.util.Map;

public class CommandFactoryImpl implements CommandFactory {

    @Override
    public Command createNavigateToNewRecipeCommand(){
        return new NavigateToNewRecipe();
    }

    @Override
    public Command createNavigateToContinueCookingCommand() {
        return new NavigateToContinueCooking();
    }

    @Override
    public Command createNavigateToMainCommand(){
        return new NavigateToMain();
    }

    @Override
    public Command createNavigateToListOfMatchedRecipesCommand(RecipeService recipeService){
        return new NavigateToListOfMatchedRecipes(recipeService);
    }

    @Override
    public Command createNavigateToCookingProcessCommand(){
        return new NavigateToCookingProcess();
    }

    @Override
    public Command createNavigateToListOfRecipesCommand(RecipeService recipeService){
        return new NavigateToListOfRecipes(recipeService);
    }

    @Override
    public Command createNavigateToAddProductCommand(){
        return new NavigateToAddProduct();
    }

    @Override
    public Command createAddProductCommand(){
        return new AddProduct();
    }
}
