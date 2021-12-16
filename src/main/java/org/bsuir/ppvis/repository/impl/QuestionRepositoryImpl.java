package org.bsuir.ppvis.repository.impl;

import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.model.question.impl.QuestionWithOneAnswer;
import org.bsuir.ppvis.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {
    private List<BaseQuestion> newRecipeQuestions;

    private QuestionRepositoryImpl(){

    }

    private static class Holder
    {
        private static final QuestionRepositoryImpl INSTANCE = new QuestionRepositoryImpl();
    }

    public static QuestionRepositoryImpl getInstance()
    {
        return Holder.INSTANCE;
    }

    public void setNewRecipeQuestions(List<BaseQuestion> newRecipeQuestions) {
        this.newRecipeQuestions = newRecipeQuestions;
    }

    @Override
    public List<BaseQuestion> getNewRecipeQuestions() {
        return newRecipeQuestions;
    }
}
