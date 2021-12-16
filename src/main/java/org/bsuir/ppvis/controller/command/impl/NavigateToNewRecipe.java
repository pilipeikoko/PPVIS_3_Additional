package org.bsuir.ppvis.controller.command.impl;

import org.bsuir.ppvis.controller.command.Command;
import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.repository.QuestionRepository;
import org.bsuir.ppvis.repository.impl.QuestionRepositoryImpl;
import org.bsuir.ppvis.view.MainFrame;
import org.bsuir.ppvis.model.UserContext;

import java.util.List;

public class NavigateToNewRecipe implements Command {
    @Override
    public void execute(MainFrame frame, UserContext context) {
        QuestionRepository questionRepository = QuestionRepositoryImpl.getInstance();
        List<BaseQuestion> questions =  questionRepository.getNewRecipeQuestions();

        frame.showForNewRecipe(questions);
    }
}
