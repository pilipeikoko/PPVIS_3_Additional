package org.bsuir.ppvis.model.question.validator.impl;

import org.bsuir.ppvis.model.question.OneAnswerProvider;
import org.bsuir.ppvis.model.question.validator.MatchValidator;

public class OneAnswerValidator implements MatchValidator {
    private final String requiredAnswer;


    public OneAnswerValidator(String requiredAnswer) {
        this.requiredAnswer = requiredAnswer;
    }

    @Override
    public boolean validate(OneAnswerProvider provider) {
        return provider.getAnswer().equals(requiredAnswer);
    }
}
