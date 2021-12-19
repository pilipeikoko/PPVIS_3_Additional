package org.bsuir.ppvis.service;

import org.bsuir.ppvis.model.Recipe;
import org.bsuir.ppvis.model.User;
import org.bsuir.ppvis.model.question.BaseQuestion;

import java.util.List;

public interface RecipeService {

    List<Recipe> getSuitableRecipes(List<BaseQuestion> newRecipeQuestions, User user);

    List<Recipe> getAllRecipes();
}
