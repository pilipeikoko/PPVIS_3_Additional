package org.bsuir.ppvis.controller.command.impl;

import org.bsuir.ppvis.controller.command.ExtendedCommand;
import org.bsuir.ppvis.model.Cutlery;
import org.bsuir.ppvis.model.ExtendedUser;
import org.bsuir.ppvis.model.UserContext;
import org.bsuir.ppvis.view.MainFrame;
import org.bsuir.ppvis.view.impl.ConsoleMainFrameExtended;

public class AddCutlery implements ExtendedCommand {
    @Override
    public void execute(MainFrame frame, UserContext context) {
        execute((ConsoleMainFrameExtended) frame,context);
    }

    @Override
    public void execute(ConsoleMainFrameExtended frame, UserContext context) {
        ExtendedUser user =(ExtendedUser) context.getUser();

        user.addCultery(new Cutlery(frame.getCutleryName()),frame.getCutleryAmount());
        frame.showForMain();
    }
}