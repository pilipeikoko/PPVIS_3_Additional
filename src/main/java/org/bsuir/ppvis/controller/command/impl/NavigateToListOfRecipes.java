package org.bsuir.ppvis.controller.command.impl;

import org.bsuir.ppvis.controller.command.Command;
import org.bsuir.ppvis.model.Recipe;
import org.bsuir.ppvis.model.UserContext;
import org.bsuir.ppvis.service.RecipeService;
import org.bsuir.ppvis.view.MainFrame;

import java.util.List;

public class NavigateToListOfRecipes implements Command {
    private final RecipeService recipeService;

    public NavigateToListOfRecipes(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @Override
    public void execute(MainFrame frame, UserContext context) {
        List<Recipe> allRecipes = recipeService.getAllRecipes();

        frame.showForListOfRecipes(allRecipes);
    }
}
