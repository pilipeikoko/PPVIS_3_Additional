package org.bsuir.ppvis.controller.command.impl;

import org.bsuir.ppvis.controller.command.Command;
import org.bsuir.ppvis.model.UserContext;
import org.bsuir.ppvis.view.MainFrame;

public class NavigateToCookingProcess implements Command {
    @Override
    public void execute(MainFrame frame, UserContext context) {
        frame.showForCookingProcess(frame.getListOfRecipesChosenRecipe());
        frame.showForMain();
    }
}
