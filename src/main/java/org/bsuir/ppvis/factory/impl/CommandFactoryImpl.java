package org.bsuir.ppvis.factory.impl;

import org.bsuir.ppvis.controller.command.Command;
import org.bsuir.ppvis.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactoryImpl {

    public Map<String, Command> create(){
        Map<String, Command> commands = new HashMap<>();

        commands.put("NavigateToNewRecipe", new NavigateToNewRecipe());
        commands.put("NavigateToMain", new NavigateToMain());
        commands.put("NavigateToListOfMatchedRecipes", new NavigateToListOfMatchedRecipes());
        commands.put("NavigateToCookingProcess", new NavigateToCookingProcess());
        commands.put("NavigateToListOfRecipes", new NavigateToListOfRecipes());
        commands.put("NavigateToAddProduct", new NavigateToAddProduct());
        commands.put("AddProduct", new AddProduct());

        return commands;
    }
}
