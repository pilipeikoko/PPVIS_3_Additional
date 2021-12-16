package org.bsuir.ppvis.model.question.impl;

import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.model.question.OneAnswerProvider;

import java.util.Scanner;

public class QuestionWithOneAnswer extends BaseQuestion implements OneAnswerProvider {
    private String answer;

    public QuestionWithOneAnswer(String description) {
        super(description);
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public void ask() {
        System.out.println(description);
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
