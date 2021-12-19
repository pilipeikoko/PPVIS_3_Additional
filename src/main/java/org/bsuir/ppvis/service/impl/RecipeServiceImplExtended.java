package org.bsuir.ppvis.service.impl;

import org.bsuir.ppvis.model.Cutlery;
import org.bsuir.ppvis.model.ExtendedUser;
import org.bsuir.ppvis.model.Recipe;
import org.bsuir.ppvis.model.User;
import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.model.question.ExtendedRecipe;
import org.bsuir.ppvis.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.List;

public class RecipeServiceImplExtended extends RecipeServiceImpl {
    public RecipeServiceImplExtended(RecipeRepository recipeRepository) {
        super(recipeRepository);
    }

    @Override
    public List<Recipe> getSuitableRecipes(List<BaseQuestion> newRecipeQuestions, User user) {
        ExtendedUser extendedUser = (ExtendedUser) user;
        List<Recipe> recipes = super.getSuitableRecipes(newRecipeQuestions, user);

        List<Recipe> result = new ArrayList<>();

        for (Recipe recipe : recipes) {
            ExtendedRecipe extendedRecipe = (ExtendedRecipe) recipe;
            for (Cutlery cutlery : extendedRecipe.getCutleries()) {
                if (!extendedUser.getCutleries().containsKey(cutlery)) {
                    break;
                }
                result.add(recipe);
            }
        }
        return result;
    }
}
