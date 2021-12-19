package org.bsuir.ppvis.model.question.impl;

import org.bsuir.ppvis.model.question.BaseQuestion;
import org.bsuir.ppvis.model.question.NumericAnswerProvider;

import java.util.Scanner;

public class QuestionWithNumericAnswer extends BaseQuestion implements NumericAnswerProvider {
    private int answer;

    public QuestionWithNumericAnswer(String description) {
        super(description);
    }

    @Override
    public void ask() {
        System.out.println(description);
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextInt();
    }

    @Override
    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
