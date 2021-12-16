package org.bsuir.ppvis.repository;

import org.bsuir.ppvis.model.Recipe;

import java.util.List;

public interface RecipeRepository {
    List<Recipe> getAllRecipes();
    void setAllRecipes(List<Recipe> allRecipes);
}
