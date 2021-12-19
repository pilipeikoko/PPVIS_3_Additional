package org.bsuir.ppvis.controller.command.impl;

import org.bsuir.ppvis.controller.command.ExtendedCommand;
import org.bsuir.ppvis.model.UserContext;
import org.bsuir.ppvis.view.MainFrame;
import org.bsuir.ppvis.view.impl.ConsoleMainFrameExtended;

public class NavigateToAddCutlery implements ExtendedCommand {
    @Override
    public void execute(MainFrame frame, UserContext context) {
        execute((ConsoleMainFrameExtended) frame, context);
    }

    @Override
    public void execute(ConsoleMainFrameExtended frame, UserContext context) {
        frame.showForAddCutlery();
    }
}