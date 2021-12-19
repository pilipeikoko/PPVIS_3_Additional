package org.bsuir.ppvis.controller;

import org.bsuir.ppvis.controller.command.ExtendedCommand;
import org.bsuir.ppvis.factory.CommandFactory;
import org.bsuir.ppvis.model.UserContext;
import org.bsuir.ppvis.observer.MainFrameEvent;
import org.bsuir.ppvis.view.MainFrame;

public class MainControllerExtended extends MainController{
    public MainControllerExtended(MainFrame mainFrame, UserContext context, CommandFactory commandFactory) {
        super(mainFrame, context, commandFactory);
    }

    @Override
    public void parameterChanged(MainFrameEvent event) {
        super.parameterChanged(event);
        switch (event.getProperty()) {
            case "shouldShowNavigateToAddCutlery": {
                handleNavigateToAddCutlery();
                break;
            }
            case "shouldAddCutlery": {
                handleAddCutlery();
                break;
            }
        }
    }

    protected void handleAddCutlery() {
        addCutlery();
    }

    protected void handleNavigateToAddCutlery() {
        navigateToAddCutlery();
    }

    private void addCutlery() {
        executeCommand(commands.get("AddCutlery"));
    }

    private void navigateToAddCutlery() {
        executeCommand(commands.get("NavigateToAddCutlery"));
    }

    private void executeCommand(ExtendedCommand command) {
        command.execute(mainFrame, userContext);
    }
}
