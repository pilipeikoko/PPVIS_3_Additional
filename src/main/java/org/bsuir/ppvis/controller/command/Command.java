package org.bsuir.ppvis.controller.command;

import org.bsuir.ppvis.view.MainFrame;
import org.bsuir.ppvis.model.UserContext;

public interface Command {
    void execute(MainFrame frame, UserContext context);
}
