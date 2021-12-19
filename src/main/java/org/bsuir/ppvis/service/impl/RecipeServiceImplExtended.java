package org.bsuir.ppvis.service.impl;

import org.bsuir.ppvis.model.*;
import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeServiceImplExtended extends RecipeServiceImpl {

    public RecipeServiceImplExtended(RecipeRepository recipeRepository) {
        super(recipeRepository);
    }

    @Override
    public List<Recipe> getSuitableRecipes(List<BaseQuestion> newRecipeQuestions, User user) {
        List<Recipe> recipes = super.getSuitableRecipes(newRecipeQuestions, user);

        AlergicUser algergicUser = (AlergicUser) user;

        List<Recipe> result = new ArrayList<>();

        for (Recipe recipe : recipes) {
            for (Product product : recipe.getSteps().stream().map(RecipeStep::getProduct).collect(Collectors.toList())) {
                if (algergicUser.getAlergies().contains(product)) {
                    break;
                }
                result.add(recipe);
            }
        }

        return result;
    }
}