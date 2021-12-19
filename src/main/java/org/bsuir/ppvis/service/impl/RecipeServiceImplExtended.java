package org.bsuir.ppvis.service.impl;

import org.bsuir.ppvis.model.Recipe;
import org.bsuir.ppvis.model.User;
import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.repository.RecipeRepository;

import java.util.List;

public class RecipeServiceImplExtended extends RecipeServiceImpl {
    public RecipeServiceImplExtended(RecipeRepository recipeRepository) {
        super(recipeRepository);
    }

    @Override
    public List<Recipe> getSuitableRecipes(List<BaseQuestion> newRecipeQuestions, User user) {
        List<Recipe> recipes =  super.getSuitableRecipes(newRecipeQuestions, user);

        //TODO: to be added
        //foreach recipe convert its step amount to its value multiplied by NumericAnswerProvider

        return recipes;
    }
}
