package org.bsuir.ppvis.model;

import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.model.question.impl.QuestionWithOneAnswer;
import org.bsuir.ppvis.model.question.validator.MatchValidator;
import org.bsuir.ppvis.model.question.validator.impl.AnyOfProductsValidator;
import org.bsuir.ppvis.model.question.validator.impl.OneAnswerValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recipe {
    private final List<MatchValidator> validators;
    private final List<QuestionWithOneAnswer> questions;
    private final List<RecipeStep> steps;

    public Recipe(List<QuestionWithOneAnswer> questions, List<RecipeStep> steps) {
        this.questions = questions;
        this.steps = steps;

        this.validators = new ArrayList<>();
        validators.add(new AnyOfProductsValidator(steps.stream().map(RecipeStep::getProduct).collect(Collectors.toList())));
        for (QuestionWithOneAnswer question : questions) {
            validators.add(new OneAnswerValidator(question.getAnswer()));
        }
    }

    public boolean isMatch(List<BaseQuestion> questions) {
        for (QuestionWithOneAnswer question : this.questions) {
            if (questions.stream().anyMatch(x -> x.getDescription().equals(question.getDescription()))
                    && validators.stream().anyMatch(x->x.validate(question))) {
                continue;
            }
            return false;
        }
        return true;
    }

    public void show() {
        System.out.println(steps.toString());
    }


    public List<RecipeStep> getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
