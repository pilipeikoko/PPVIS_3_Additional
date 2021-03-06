package org.bsuir.ppvis.service.impl;

import org.bsuir.ppvis.model.User;
import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.service.RecipeService;
import org.bsuir.ppvis.model.Recipe;
import org.bsuir.ppvis.repository.RecipeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeServiceImpl implements RecipeService {
    protected final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getSuitableRecipes(List<BaseQuestion> newRecipeQuestions, User user) {
        List<Recipe> allRecipes = recipeRepository.getAllRecipes();

        return allRecipes.stream().filter(x -> x.isMatch(newRecipeQuestions)).collect(Collectors.toList());
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }
}
