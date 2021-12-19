package org.bsuir.ppvis.factory.impl;

import org.bsuir.ppvis.controller.command.Command;
import org.bsuir.ppvis.controller.command.impl.AddCutlery;
import org.bsuir.ppvis.controller.command.impl.NavigateToAddCutlery;
import org.bsuir.ppvis.service.RecipeService;

import java.util.Map;

public class CommandFactoryImplExtended extends CommandFactoryImpl{
    public CommandFactoryImplExtended(RecipeService recipeService) {
        super(recipeService);
    }

    @Override
    public Map<String, Command> create() {
        Map<String, Command> commands =  super.create();

        commands.put("NavigateToAddCutlery", new NavigateToAddCutlery());
        commands.put("AddCutlery", new AddCutlery());

        return commands;
    }
}