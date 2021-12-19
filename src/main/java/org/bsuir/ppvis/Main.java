package org.bsuir.ppvis;

import org.bsuir.ppvis.controller.MainController;
import org.bsuir.ppvis.factory.CommandFactory;
import org.bsuir.ppvis.factory.impl.CommandFactoryImpl;
import org.bsuir.ppvis.model.*;
import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.model.question.impl.QuestionWithNumericAnswer;
import org.bsuir.ppvis.model.question.impl.QuestionWithOneAnswer;
import org.bsuir.ppvis.repository.QuestionRepository;
import org.bsuir.ppvis.repository.RecipeRepository;
import org.bsuir.ppvis.repository.impl.QuestionRepositoryImpl;
import org.bsuir.ppvis.repository.impl.RecipeRepositoryImpl;
import org.bsuir.ppvis.service.RecipeService;
import org.bsuir.ppvis.service.impl.RecipeServiceImpl;
import org.bsuir.ppvis.view.MainFrame;
import org.bsuir.ppvis.view.impl.ConsoleMainFrame;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        mockRepositoriesAndInject();
    }

    private static void mockRepositoriesAndInject() {
        QuestionRepository questionRepository = QuestionRepositoryImpl.getInstance();

        List<BaseQuestion> newRecipeQuestions = new ArrayList<>();

        QuestionWithOneAnswer question1 = new QuestionWithOneAnswer("Breakfast, lunch or dinner?");
        QuestionWithOneAnswer question2 = new QuestionWithOneAnswer("Required product in recipe?");
        QuestionWithNumericAnswer additional = new QuestionWithNumericAnswer("How many people?");

        newRecipeQuestions.add(question1);
        newRecipeQuestions.add(question2);
        newRecipeQuestions.add(additional);

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

        MainFrame frame = new ConsoleMainFrame();
        UserContext context = new UserContext();

        context.setUser(new User());

        RecipeService service = new RecipeServiceImpl(recipeRepository);
        CommandFactory factory = new CommandFactoryImpl(service);

        new MainController(frame, context, factory).start();
    }


}
