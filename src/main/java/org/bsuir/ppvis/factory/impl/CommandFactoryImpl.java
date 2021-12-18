package org.bsuir.ppvis.factory.impl;

import org.bsuir.ppvis.controller.command.Command;
import org.bsuir.ppvis.controller.command.impl.*;
import org.bsuir.ppvis.factory.CommandFactory;
import org.bsuir.ppvis.service.RecipeService;

import java.util.HashMap;
import java.util.Map;

public class CommandFactoryImpl implements CommandFactory {
    private final RecipeService recipeService;

    public CommandFactoryImpl(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    public Map<String, Command> create() {
        Map<String, Command> commands = new HashMap<>();

        commands.put("NavigateToNewRecipe", new NavigateToNewRecipe());
        commands.put("NavigateToMain", new NavigateToMain());
        commands.put("NavigateToListOfMatchedRecipes", new NavigateToListOfMatchedRecipes(recipeService));
        commands.put("NavigateToCookingProcess", new NavigateToCookingProcess());
        commands.put("NavigateToListOfRecipes", new NavigateToListOfRecipes(recipeService));
        commands.put("NavigateToAddProduct", new NavigateToAddProduct());
        commands.put("AddProduct", new AddProduct());
        commands.put("NavigateToContinueCooking", new NavigateToContinueCooking());

        return commands;
    }
}