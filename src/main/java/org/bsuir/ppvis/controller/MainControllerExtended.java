package org.bsuir.ppvis.controller;

import org.bsuir.ppvis.controller.command.ExtendedCommand;
import org.bsuir.ppvis.factory.CommandFactory;
import org.bsuir.ppvis.model.UserContext;
import org.bsuir.ppvis.observer.MainFrameEvent;
import org.bsuir.ppvis.view.MainFrame;

public class MainControllerExtended extends MainController {
    public MainControllerExtended(MainFrame mainFrame, UserContext context, CommandFactory commandFactory) {
        super(mainFrame, context, commandFactory);

        handleMainAction();
    }

    @Override
    public void parameterChanged(MainFrameEvent event) {
        super.parameterChanged(event);
        switch (event.getProperty()) {
            case "shouldShowNavigateToAddAlergy": {
                handleNavigateToAddAlergy();
                break;
            }
            case "shouldAddAlergy": {
                handleAddAlergy();
                break;
            }
        }
    }

    protected void handleAddAlergy() {
        addAlergy();
    }

    protected void handleNavigateToAddAlergy() {
        navigateToAddAlergy();
    }

    private void addAlergy() {
        executeCommand(commands.get("AddAlergy"));
    }

    private void navigateToAddAlergy() {
        executeCommand(commands.get("NavigateToAddAlergy"));
    }

    private void executeCommand(ExtendedCommand command) {
        command.execute(mainFrame, userContext);
    }

}
