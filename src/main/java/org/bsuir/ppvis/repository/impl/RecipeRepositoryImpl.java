package org.bsuir.ppvis.repository.impl;

import org.bsuir.ppvis.model.Recipe;
import org.bsuir.ppvis.repository.RecipeRepository;

import java.util.List;

public class RecipeRepositoryImpl implements RecipeRepository {
    private List<Recipe> allRecipes;

    private RecipeRepositoryImpl(){

    }

    private static class Holder
    {
        private static final RecipeRepositoryImpl INSTANCE = new RecipeRepositoryImpl();
    }

    public static RecipeRepositoryImpl getInstance()
    {
        return RecipeRepositoryImpl.Holder.INSTANCE;
    }

    public List<Recipe> getAllRecipes() {
        return allRecipes;
    }

    public void setAllRecipes(List<Recipe> allRecipes) {
        this.allRecipes = allRecipes;
    }
}
