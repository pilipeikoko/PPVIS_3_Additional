package org.bsuir.ppvis.controller.command;

import org.bsuir.ppvis.model.UserContext;
import org.bsuir.ppvis.view.impl.ConsoleMainFrameExtended;

public interface ExtendedCommand extends Command {
    void execute(ConsoleMainFrameExtended frame, UserContext context);
}