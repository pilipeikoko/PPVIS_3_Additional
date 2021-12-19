package org.bsuir.ppvis.controller.command.impl;

import org.bsuir.ppvis.controller.command.ExtendedCommand;
import org.bsuir.ppvis.model.AlergicUser;
import org.bsuir.ppvis.model.Alergy;
import org.bsuir.ppvis.model.UserContext;
import org.bsuir.ppvis.view.MainFrame;
import org.bsuir.ppvis.view.impl.ConsoleMainFrameExtended;

public class AddAlergy implements ExtendedCommand {
    @Override
    public void execute(ConsoleMainFrameExtended frame, UserContext context) {
        Alergy alergy = new Alergy(frame.getAlergyName(),frame.getAlergyProducts());

        AlergicUser user = (AlergicUser) context.getUser();
        user.addAlergy(alergy);

        frame.showForMain();
    }

    @Override
    public void execute(MainFrame frame, UserContext context) {
        //How can we overcome casting?
        //Is it even possible? Never seen such cases
        execute((ConsoleMainFrameExtended) frame, context);
    }
}