package org.bsuir.ppvis.repository;

import org.bsuir.ppvis.model.question.BaseQuestion;

import java.util.List;

public interface QuestionRepository {
    List<BaseQuestion> getNewRecipeQuestions();
    void setNewRecipeQuestions(List<BaseQuestion> newRecipeQuestions);
}
