package org.bsuir.ppvis.model.question;

import org.bsuir.ppvis.model.Cutlery;
import org.bsuir.ppvis.model.Recipe;
import org.bsuir.ppvis.model.RecipeStep;
import org.bsuir.ppvis.model.question.impl.QuestionWithOneAnswer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExtendedRecipe extends Recipe {
    private final Set<Cutlery> cutleries;

    {
        cutleries = new HashSet<>();
    }

    public ExtendedRecipe(List<QuestionWithOneAnswer> questions, List<RecipeStep> steps) {
        super(questions, steps);
    }

    public void addCutlery(Cutlery cutlery){
        cutleries.add(cutlery);
    }

    public Set<Cutlery> getCutleries() {
        return cutleries;
    }

}
