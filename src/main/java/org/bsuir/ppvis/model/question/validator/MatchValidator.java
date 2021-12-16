package org.bsuir.ppvis.model.question.validator;

import org.bsuir.ppvis.model.question.OneAnswerProvider;

public interface MatchValidator {
    boolean validate(OneAnswerProvider provider);
}
