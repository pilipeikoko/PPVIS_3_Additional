package org.bsuir.ppvis;

import org.bsuir.ppvis.controller.MainController;
import org.bsuir.ppvis.model.Product;
import org.bsuir.ppvis.model.Recipe;
import org.bsuir.ppvis.model.RecipeStep;
import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.model.question.impl.QuestionWithOneAnswer;
import org.bsuir.ppvis.repository.QuestionRepository;
import org.bsuir.ppvis.repository.RecipeRepository;
import org.bsuir.ppvis.repository.impl.QuestionRepositoryImpl;
import org.bsuir.ppvis.repository.impl.RecipeRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        mockRepositories();

        new MainController();
    }

    private static void mockRepositories() {
        QuestionRepository questionRepository = QuestionRepositoryImpl.getInstance();

        List<BaseQuestion> newRecipeQuestions = new ArrayList<>();

        QuestionWithOneAnswer question1 = new QuestionWithOneAnswer("Breakfast, lunch or dinner?");
        QuestionWithOneAnswer question2 = new QuestionWithOneAnswer("Required product in recipe?");

        newRecipeQuestions.add(question1);
        newRecipeQuestions.add(question2);

        questionRepository.setNewRecipeQuestions(newRecipeQuestions);




        RecipeRepository recipeRepository = RecipeRepositoryImpl.getInstance();

        List<Recipe> recipes = new ArrayList<>();


        List<RecipeStep> recipeSteps = new ArrayList<>();

        recipeSteps.add(new RecipeStep(new Product("cheese"), 2, "Just add"));
        recipeSteps.add(new RecipeStep(new Product("bacon"), 3, "Just add it"));

        List<QuestionWithOneAnswer> questions = new ArrayList<>();

        QuestionWithOneAnswer question3 = new QuestionWithOneAnswer("Breakfast, lunch or dinner?");
        question3.setAnswer("lunch");
        QuestionWithOneAnswer question4 = new QuestionWithOneAnswer("Required product in recipe?");
        question4.setAnswer("cheese");

        questions.add(question3);
        questions.add(question4);

        Recipe firstRecipe = new Recipe(questions, recipeSteps);
        recipes.add(firstRecipe);

        recipeRepository.setAllRecipes(recipes);
    }



}