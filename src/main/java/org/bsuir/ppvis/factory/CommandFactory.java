package org.bsuir.ppvis.factory;

import org.bsuir.ppvis.controller.command.Command;

import java.util.Map;

public interface CommandFactory {
    Map<String, Command> create();
}