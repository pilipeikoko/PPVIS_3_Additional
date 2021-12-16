package org.bsuir.ppvis.model.question;

public abstract class BaseQuestion {
    protected String description;

    public BaseQuestion(String description)
    {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void ask();
}
