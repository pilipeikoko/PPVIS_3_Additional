package org.bsuir.ppvis.view.impl;

import org.bsuir.ppvis.model.Recipe;
import org.bsuir.ppvis.model.RecipeStep;
import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.view.MainFrame;

import java.util.List;
import java.util.Scanner;

public class ConsoleMainFrame extends MainFrame {

    @Override
    public void showForNewRecipe(List<BaseQuestion> questions) {
        for (BaseQuestion question : questions){
            question.ask();
        }

        setNewRecipeQuestions(questions);
    }

    @Override
    public void showForMain() {
        System.out.println("1. New recipe");
        System.out.println("2. Continue current");
        System.out.println("3. Look all recipes");
        System.out.println("4. Add product2");
        Scanner scanner = new Scanner(System.in);

        setMainActionType(Integer.parseInt(scanner.nextLine()));
    }

    @Override
    public void showForListOfRecipes(List<Recipe> recipes) {
        for(int i=0;i<recipes.size();++i){
            Recipe recipe = recipes.get(i);
            System.out.print(i + ") ");
            recipe.show();
            System.out.println();
        }

        System.out.println("Choose recipe you like");
        Scanner scanner = new Scanner(System.in);

        setListOfRecipesChosenRecipe(recipes.get(scanner.nextInt()));
    }

    @Override
    public void showForCookingProcess(Recipe recipe) {
        Scanner scanner = new Scanner(System.in);
        for(RecipeStep step:recipe.getSteps()){
            System.out.println(step.toString());
            scanner.next();
        }
    }

    @Override
    public void showForAddProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Product name : ");
        setProductName(scanner.nextLine());

        System.out.println("amount : ");
        setProductAmount(scanner.nextInt());
    }
}
